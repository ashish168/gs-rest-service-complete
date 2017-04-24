package lakshya.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Stock implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "STOCK_ID")
	public int stockId ;
	public String stockExchangeCode;
	public int stockValueInUsd;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "stock")
	public Set<StockValueInDiffCurrencies> stockValueInDiffCurrencies = new HashSet<StockValueInDiffCurrencies>(0);

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockExchangeCode() {
		return stockExchangeCode;
	}

	public void setStockExchangeCode(String stockExchangeCode) {
		this.stockExchangeCode = stockExchangeCode;
	}

	public int getStockValueInUsd() {
		return stockValueInUsd;
	}

	public void setStockValueInUsd(int stockValueInUsd) {
		this.stockValueInUsd = stockValueInUsd;
	}

	public Set<StockValueInDiffCurrencies> getStockValueInDiffCurrencies() {
		return stockValueInDiffCurrencies;
	}

	public void setStockValueInDiffCurrencies(Set<StockValueInDiffCurrencies> stockValueInDiffCurrencies) {
		this.stockValueInDiffCurrencies = stockValueInDiffCurrencies;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockExchangeCode=" + stockExchangeCode + ", stockValueInUsd="
				+ stockValueInUsd + ", stockValueInDiffCurrencies=" + stockValueInDiffCurrencies + "]";
	}

	
}
