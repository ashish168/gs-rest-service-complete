package lakshya.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TemperatureOfCity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String cityCode;
	public double temperature;
	public String unit = "C";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "TemperatureOfCity [id=" + id + ", cityCode=" + cityCode + ", temperature=" + temperature + ", unit="
				+ unit + "]";
	}
	
	
	
	
}