package lakshya.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lakshya.model.TemperatureOfCity;

public interface TemperatureOfCityRepository  extends CrudRepository<TemperatureOfCity, Long> {

	List<TemperatureOfCity> findByCityCode(String cityCode);
	
}
