package lakshya.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StockValueInDiffCurrencies implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int currId;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "STOCK_ID", nullable = false)
	@JsonIgnore
	public Stock stock;
	
	public String stockCurrencyUnit;
	public int stockCurrencyValue;
	public int getCurrId() {
		return currId;
	}
	public void setCurrId(int currId) {
		this.currId = currId;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	public String getStockCurrencyUnit() {
		return stockCurrencyUnit;
	}
	public void setStockCurrencyUnit(String stockCurrencyUnit) {
		this.stockCurrencyUnit = stockCurrencyUnit;
	}
	public int getStockCurrencyValue() {
		return stockCurrencyValue;
	}
	
	public void setStockCurrencyValue(int stockCurrencyValue) {
		this.stockCurrencyValue = stockCurrencyValue;
	}
	@Override
	public String toString() {
		return "StockValueInDiffCurrencies [currId=" + currId + ", stock=" + stock + ", stockCurrencyUnit="
				+ stockCurrencyUnit + ", stockCurrencyValue=" + stockCurrencyValue + "]";
	}
	
	
	
}
