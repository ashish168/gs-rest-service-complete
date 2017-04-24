package lakshya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lakshya.model.StockValueInDiffCurrencies;
import lakshya.repository.jpa.StockValueInDiffCurrenciesRepository;

@Service
public class StockValueInDiffCurrenciesServiceImpl implements StockValueInDiffCurrenciesService {
	private StockValueInDiffCurrenciesRepository stockValueInDiffCurrenciesRepository;

	@Autowired
	public StockValueInDiffCurrenciesServiceImpl(StockValueInDiffCurrenciesRepository stockValueInDiffCurrenciesRepository){
		this.stockValueInDiffCurrenciesRepository = stockValueInDiffCurrenciesRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<StockValueInDiffCurrencies> findByCurrId(int id) throws DataAccessException{
		return this.stockValueInDiffCurrenciesRepository.findByCurrId(id);
	}
	
	
	@Override
	@Transactional
	public void saveStockValueInDiffCurrencies(StockValueInDiffCurrencies stockValueInDiffCurrencies) throws DataAccessException{
		this.stockValueInDiffCurrenciesRepository.save(stockValueInDiffCurrencies);
	}

	
}
