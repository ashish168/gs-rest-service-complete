package lakshya.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lakshya.model.StockValueInDiffCurrencies;

public interface StockValueInDiffCurrenciesRepository extends CrudRepository<StockValueInDiffCurrencies, Long> {
	List<StockValueInDiffCurrencies> findByCurrId(int id);
}
