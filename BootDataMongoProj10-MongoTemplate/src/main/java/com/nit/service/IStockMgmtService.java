package com.nit.service;

import java.util.List;

import com.nit.document.StockDetails;

public interface IStockMgmtService {
	public String registerStockDetails(StockDetails details);
	public String updateStockDetails(StockDetails details);
	public String registerStockDetailsInBatch(List<StockDetails> list);
	public List<StockDetails> fetchStocksDetailsByExchange(String exchange);
	public List<StockDetails> fetchStockDetailsByPriceRange(double startPrice, double endPrice);
	public StockDetails fetchStockDetailsByStockId(int stockId);
	public String fetchAndUpdateStockDetailsByStockId(int stockId, double newPrice, String newExchangeName);
	public String modifyExchangeByStockPriceRange(double startPrice, double endPrice, String newExhangeName);
	public String registerOrUpdateStockByStockName(String stockName, double newPrice, String newExchangeName);
	public String fetchAndRemoveByStockName(String stockName);
	public String fetchAllAndRemoveByExchangeName(String exchange);
}
