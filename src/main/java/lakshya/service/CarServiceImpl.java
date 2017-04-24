package lakshya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lakshya.model.Car;
import lakshya.repository.jpa.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	private CarRepository carRepository;

	@Autowired
	public CarServiceImpl(CarRepository carRepository){
		this.carRepository = carRepository;
	}
	
	 @Transactional(readOnly = true)
	public List<Car> findByManufacturer(String manufacturer) throws DataAccessException {
		return carRepository.findByManufacturer(manufacturer);
	}
	
	 @Override
	 @Transactional(readOnly = true)
	public List<Car> findByModel(String model) throws DataAccessException {
		 return carRepository.findByModel(model);
	}
	
	 
	 @Override
	 @Transactional(readOnly = true)
	public List<Car> findByManufacturerAndModel(String manufacturer,String model) throws DataAccessException{
		return carRepository.findByManufacturerAndModel(manufacturer, model);
	}
	
	 @Override
	 @Transactional
	public void saveCar(Car c){
		carRepository.save(c);
	}

}
