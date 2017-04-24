package lakshya.web;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lakshya.model.TemperatureOfCity;
import lakshya.service.TemperatureService;

//restControllers automatically returns json 
@RestController
public class TemperatureController {
	private final TemperatureService temperatureService;
	
	 @Autowired
	 TemperatureController(TemperatureService temperatureService) {
			this.temperatureService = temperatureService;
			
		}
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/cityTemp", consumes = {"application/json" })
	   	public @ResponseBody TemperatureOfCity cityTempInfo(@RequestBody TemperatureOfCity tempOfCity) throws Exception {
	    	System.out.println("inside cityTemp info , value passed is:"+tempOfCity);
	    	TemperatureOfCity result = null;
	    
	    	/*
	    	 * ======================
	    	 * dummy data creation starts
	    	 * */
	    	TemperatureOfCity t1 = new TemperatureOfCity();
	    	t1.setCityCode("DEL");
	    	t1.setTemperature(100);
	    	t1.setUnit("C");
	    	temperatureService.saveTemperatureOfCity(t1);
	    	
	    	TemperatureOfCity t2 = new TemperatureOfCity();
	    	t2.setCityCode("GGN");
	    	t2.setTemperature(40);
	    	t2.setUnit("C");
	    	temperatureService.saveTemperatureOfCity(t2);
	    	
	    	/*
	    	 *
	    	 * dummy data creation ends
	    	 * ======================
	    	 * */ 
	    
	    	System.out.println("number of objects found in db is:"+temperatureService.findByCityCode(tempOfCity.getCityCode()).size());
	    	Random r = new Random();
	    	if(temperatureService.findByCityCode(tempOfCity.getCityCode()).size() >=1){
	    		System.out.println("instance found in db");
	    		result = temperatureService.findByCityCode(tempOfCity.getCityCode()).get(0); 
	    		Double value = result.getTemperature();
	    		value = Double.valueOf(r.nextInt(100));
	    		if(tempOfCity.getUnit().equals("F")){
	    			value = (value * 1.8) + 32;
	    			result.setUnit("F");
	    			result.setTemperature(value);
	    		}
	    	}else {
	    		throw new Exception("Global Exception : CityCode not found , Please provide correct City Code");
	    	}
	    	System.out.println("value of result is :"+result);
	    	return result;
	    }
}
