package lakshya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lakshya.model.TemperatureOfCity;
import lakshya.repository.jpa.TemperatureOfCityRepository;

@Service
public class TemperatureServiceImpl implements TemperatureService{
	private TemperatureOfCityRepository temperatureOfCityRepository;
	
	@Autowired
	public TemperatureServiceImpl(TemperatureOfCityRepository temperatureOfCityRepository){
		this.temperatureOfCityRepository  = temperatureOfCityRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemperatureOfCity> findByCityCode(String cityCode) throws DataAccessException {
		return temperatureOfCityRepository.findByCityCode(cityCode);
	}
	
	@Override
	@Transactional
	public void saveTemperatureOfCity(TemperatureOfCity temperatureOfCity) throws DataAccessException {
		temperatureOfCityRepository.save(temperatureOfCity);
	}
}
