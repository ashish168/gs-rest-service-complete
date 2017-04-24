package lakshya.web;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lakshya.model.Stock;
import lakshya.model.StockValueInDiffCurrencies;
import lakshya.service.StockService;
import lakshya.service.StockValueInDiffCurrenciesService;

//restControllers automatically returns json 
@RestController
public class StockController {
	  private final StockService stockService;
	  private final StockValueInDiffCurrenciesService stockValueInDiffCurrenciesService; 
	  
	  @Autowired
	  StockController(StockService stockService , StockValueInDiffCurrenciesService stockValueInDiffCurrenciesService) {
			this.stockService = stockService;
			this.stockValueInDiffCurrenciesService = stockValueInDiffCurrenciesService;
			
		}
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/stockPrice", consumes = {"application/json" })
		public @ResponseBody Stock stockInfo(@RequestBody Stock stock) throws Exception {
	    	System.out.println("Inside stockInfo , value of info passed is :"+stock.toString());
	    	Stock result = null;
	    	/*
	    	 * ==============================================
	    	 * create random data for now
	    	 *
	    	 * */
	    	
	    	Stock s1 = new Stock();
	    	//s1.setStockId(1234);
	    	s1.setStockExchangeCode("gogl");
	    	s1.setStockValueInUsd(200);
	    	//stockRepository.save(s1);
	    	
	    	StockValueInDiffCurrencies sv1 = new StockValueInDiffCurrencies();
	    	sv1.setStock(s1);
	    	sv1.setStockCurrencyUnit("INR");
	    	sv1.setStockCurrencyValue(s1.getStockValueInUsd() * 60);
	    	System.out.println("pass1=================");
	    	stockValueInDiffCurrenciesService.saveStockValueInDiffCurrencies(sv1);
	    	s1.getStockValueInDiffCurrencies().add(sv1);
	    	
	    	StockValueInDiffCurrencies sv2 = new StockValueInDiffCurrencies();
	    	sv2.setStock(s1);
	    	sv2.setStockCurrencyUnit("CAN");
	    	sv2.setStockCurrencyValue(s1.getStockValueInUsd() * 2);
	    	System.out.println("pass2=================");
	    	stockValueInDiffCurrenciesService.saveStockValueInDiffCurrencies(sv2);
	    	s1.getStockValueInDiffCurrencies().add(sv2);
	    	
	    	StockValueInDiffCurrencies sv3 = new StockValueInDiffCurrencies();
	    	sv3.setStock(s1);
	    	sv3.setStockCurrencyUnit("AUS");
	    	sv3.setStockCurrencyValue(s1.getStockValueInUsd() * 3);
	    	System.out.println("pass3=================");
	    	stockValueInDiffCurrenciesService.saveStockValueInDiffCurrencies(sv3);
	    	s1.getStockValueInDiffCurrencies().add(sv3);
	    	System.out.println("pass4=================");
	    	stockService.saveStock(s1);
	    	System.out.println("pass5=================");
	    	/*
	    	 *random data creation ends . 
	    	 * ============================================
	    	 */    	
	    	
	    	
	    	System.out.println("no of rows found :"+stockService.findByStockExchangeCode("gogl").size());
	    	if(stockService.findByStockExchangeCode(stock.getStockExchangeCode()).size() > 0){
	    		result = stockService.findByStockExchangeCode(stock.getStockExchangeCode()).get(0);
	    		if(stock.getStockValueInDiffCurrencies().size() > 0){
	    			Set<StockValueInDiffCurrencies> selectedCurrencies = new HashSet<StockValueInDiffCurrencies>();
	        		Set<String> unitValues = new  HashSet<String>();
	        		for(StockValueInDiffCurrencies s : stock.getStockValueInDiffCurrencies()){
	        			unitValues.add(s.getStockCurrencyUnit());
	        		}
	        		
	        		for(StockValueInDiffCurrencies s : result.getStockValueInDiffCurrencies()){
	        			if(unitValues.contains(s.getStockCurrencyUnit())){
	        				selectedCurrencies.add(s);
	        			}
	        		}
	        				
	        		result.setStockValueInDiffCurrencies(selectedCurrencies);	
	    		}
	    		return result;
	    	}else{
	    		throw new Exception("Global Exception : value for stock not found");
	    	}
	    	
	    	
		}
	  
}
