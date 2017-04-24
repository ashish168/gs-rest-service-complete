package lakshya.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lakshya.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
	List<Stock> findByStockExchangeCode(String stockExchangeCode);
}
