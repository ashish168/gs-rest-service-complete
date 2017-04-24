package lakshya.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lakshya.model.Car;


public interface CarRepository extends CrudRepository<Car, Long>{	
	List<Car> findByManufacturer(String manufacturer);
	List<Car> findByModel(String model);
	List<Car> findByManufacturerAndModel(String manufacturer,String model);
}
    
