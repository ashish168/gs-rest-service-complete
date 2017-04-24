package lakshya.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import lakshya.model.StockValueInDiffCurrencies;

public interface StockValueInDiffCurrenciesService {
	List<StockValueInDiffCurrencies> findByCurrId(int id) throws DataAccessException;
	void saveStockValueInDiffCurrencies(StockValueInDiffCurrencies stockValueInDiffCurrencies) throws DataAccessException;

}
