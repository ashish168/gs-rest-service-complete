package lakshya.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import lakshya.model.Car;

public interface CarService {
	 List<Car> findByManufacturer(String manufacturer) throws DataAccessException;
	
	List<Car> findByModel(String model) throws DataAccessException;
	
	List<Car> findByManufacturerAndModel(String manufacturer,String model) throws DataAccessException;
	
	void saveCar(Car c);
}
