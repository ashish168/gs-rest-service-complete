package lakshya.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	public String manufacturer ;
	public String model ;
	public String primaryPriceUnit="INR";
	public String secondaryPriceUnit="USD";
    public int primaryPriceUnitValue;
    public int secondaryPriceUnitValue;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrimaryPriceUnit() {
		return primaryPriceUnit;
	}
	public void setPrimaryPriceUnit(String primaryPriceUnit) {
		this.primaryPriceUnit = primaryPriceUnit;
	}
	public String getSecondaryPriceUnit() {
		return secondaryPriceUnit;
	}
	public void setSecondaryPriceUnit(String secondaryPriceUnit) {
		this.secondaryPriceUnit = secondaryPriceUnit;
	}
	public int getPrimaryPriceUnitValue() {
		return primaryPriceUnitValue;
	}
	public void setPrimaryPriceUnitValue(int primaryPriceUnitValue) {
		this.primaryPriceUnitValue = primaryPriceUnitValue;
	}
	public int getSecondaryPriceUnitValue() {
		return secondaryPriceUnitValue;
	}
	public void setSecondaryPriceUnitValue(int secondaryPriceUnitValue) {
		this.secondaryPriceUnitValue = secondaryPriceUnitValue;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", primaryPriceUnit="
				+ primaryPriceUnit + ", secondaryPriceUnit=" + secondaryPriceUnit + ", primaryPriceUnitValue="
				+ primaryPriceUnitValue + ", secondaryPriceUnitValue=" + secondaryPriceUnitValue + "]";
	}
	
	
	
}
