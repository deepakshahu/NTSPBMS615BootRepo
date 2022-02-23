package com.nit.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.document.StockDetails;
import com.nit.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {
	@Autowired
	private IStockMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*System.out.println("===============save document operation==============");
		StockDetails details = new StockDetails(new Random().nextInt(10000), "Tata Power", 235.65, "BSE");
		String result = service.registerStockDetails(details);
		System.out.println(result);*/
		
		/*System.out.println("===============update document using save method ==============");
		StockDetails details = new StockDetails(292, "HDFC", 100.65, "NSE");
		String result = service.updateStockDetails(details);
		System.out.println(result);*/
		
		/*System.out.println("===============insertAll(-) to save multiple document ==============");
		StockDetails details1 = new StockDetails(new Random().nextInt(1000), "SBI", 537.55, "BSE");
		StockDetails details2 = new StockDetails(new Random().nextInt(1000), "HDFC", 97.35, "BSE");
		StockDetails details3 = new StockDetails(new Random().nextInt(1000), "ICICI", 355.74, "BSE");
		String msg = service.registerStockDetailsInBatch(List.of(details1, details2, details3));
		System.out.println(msg);*/
		
		/*System.out.println("==========find() method for selecting the documents=============");
		service.fetchStocksDetailsByExchange("BSE").forEach(System.out::println);*/
		
		/*System.out.println("==========gte and lte method for selecting the documents=============");
		service.fetchStockDetailsByPriceRange(100.5, 9500.74).forEach(System.out::println);*/
		
		/*System.out.println("==========findById() method===========");
		System.out.println("711 stockId Stock Details are :: "+service.fetchStockDetailsByStockId(711));*/
		
		/*System.out.println("==========fetch and update by id(findAndModify)===========");
		System.out.println(service.fetchAndUpdateStockDetailsByStockId(711, 989.65, "NSE"));*/
		
		/*System.out.println("==========fetch Multiple Document By Price Range (updateMulti)===========");
		System.out.println(service.modifyExchangeByStockPriceRange(99.52, 300.65, "NYKSE"));*/
		
		/*System.out.println("==========register or update (upsert)===========");
		System.out.println(service.registerOrUpdateStockByStockName("MAWANA SUGAR", 112.78, "BSE"));*/
		
		/*System.out.println("==========fetch and Remove (findAndRemove)===========");
		System.out.println(service.fetchAndRemoveByStockName("ICICI"));*/
		
		System.out.println("==========fetch all and Remove (findAllAndRemove)===========");
		System.out.println(service.fetchAllAndRemoveByExchangeName("BSE"));
		
	}//run
}//class