package com.nit.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nit.document.StockDetails;

@Service("stockService")
public class StockMgmtServiceImpl implements IStockMgmtService {
	@Autowired
	private MongoTemplate template;

	@Override
	public String registerStockDetails(StockDetails details) {
		//int idValue = template.save(details, "stock").getStockId();  //given doc object data will be saved by creating collection called "stock"
		//int idValue = template.save(details).getStockId();  //given doc object data will be saved by creating collection with the document class name
		int idValue = template.insert(details).getStockId();  //given doc object data will be saved by creating collection with the document class name
		return "Document is saved with id value :: "+idValue;
	}

	@Override
	public String updateStockDetails(StockDetails details) {  //generally, we dont do like this, we first check id is present or not then update the value
		int idValue = template.save(details).getStockId();  //given doc object data will be updated if same id exist in DB
		return "Document is updated with id value :: "+idValue;
	}

	@Override
	public String registerStockDetailsInBatch(List<StockDetails> list) {
		int size = template.insertAll(list).size();
		return size+" no of documents are saved";
	}

	@Override
	public List<StockDetails> fetchStocksDetailsByExchange(String exchange) {
		Query query = new Query();
		query.addCriteria(Criteria.where("exchangeName").is(exchange));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public List<StockDetails> fetchStockDetailsByPriceRange(double startPrice, double endPrice) {
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).lte(endPrice));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public StockDetails fetchStockDetailsByStockId(int stockId) {
		return template.findById(stockId, StockDetails.class);
	}

	@Override
	public String fetchAndUpdateStockDetailsByStockId(int stockId, double newPrice, String newExchangeName) {
		//Query object for single document retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("stockId").is(stockId));
		//Update object for modification
		Update update = new Update();
		update.set("price", newPrice);
		update.set("exchangeName", newExchangeName);
		//Call the method
		StockDetails details = template.findAndModify(query, update, StockDetails.class);
		return details==null?"Stock not found":"Stock found and updated";
	}

	@Override
	public String modifyExchangeByStockPriceRange(double startPrice, double endPrice, String newExchangeName) {
		//Query object for multiple document retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).andOperator(Criteria.where("price").lte(endPrice)));
		//Update object for modification
		Update update = new Update().set("exchangeName", newExchangeName);
		//Call the method
		UpdateResult result = template.updateMulti(query, update, StockDetails.class);
		return result.getModifiedCount()+" no of records are affected";
	}

	@Override
	public String registerOrUpdateStockByStockName(String stockName, double newPrice, String newExchangeName) {
		//Query object for single document retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		//Update object
		Update update = new Update();
		update.set("exchangeName", newExchangeName);
		update.set("price", newPrice);
		update.setOnInsert("stockName", stockName);
		update.setOnInsert("stockId", new Random().nextInt(10000));
		//Invoke the method
		UpdateResult result = template.upsert(query, update, StockDetails.class);
		return result.getModifiedCount()+" no of records are affected";
	}

	@Override
	public String fetchAndRemoveByStockName(String stockName) {
		//Query object for single document retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		//Call the method
		StockDetails details = template.findAndRemove(query, StockDetails.class);
		return details==null?"Stock not found":"Stock found and deleted";
	}

	@Override
	public String fetchAllAndRemoveByExchangeName(String exchange) {
		//Query object for multiple document retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("exchangeName").is(exchange));
		//Call the method
		List<StockDetails> list = template.findAllAndRemove(query, StockDetails.class);
		list.forEach(System.out::println);
		return list==null?"Stock not found":"Stock found and deleted";
	}

}//class