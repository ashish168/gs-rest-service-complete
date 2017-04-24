package lakshya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lakshya.model.Stock;
import lakshya.repository.jpa.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	private StockRepository stockRepository;
	
	@Autowired
	public StockServiceImpl(StockRepository stockRepository){
		this.stockRepository = stockRepository;
	}

	 @Override
	 @Transactional(readOnly = true)
	public List<Stock> findByStockExchangeCode(String stockExchangeCode) throws DataAccessException{
		return this.stockRepository.findByStockExchangeCode(stockExchangeCode);
	}
	
	
	 @Override
	 @Transactional
	public void saveStock(Stock stock) throws DataAccessException{
		this.stockRepository.save(stock);
	}
}
