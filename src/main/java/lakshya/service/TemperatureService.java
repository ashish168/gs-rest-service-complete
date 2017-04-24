package lakshya.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import lakshya.model.TemperatureOfCity;

public interface TemperatureService {
	List<TemperatureOfCity> findByCityCode(String cityCode) throws DataAccessException;
	void saveTemperatureOfCity(TemperatureOfCity temperatureOfCity) throws DataAccessException;
}
