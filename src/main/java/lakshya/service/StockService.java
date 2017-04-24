package lakshya.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import lakshya.model.Stock;

public interface StockService {
	List<Stock> findByStockExchangeCode(String stockExchangeCode) throws DataAccessException;
	void saveStock(Stock stock) throws DataAccessException;
}
