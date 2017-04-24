package lakshya.web;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lakshya.exceptions.CarNotFoundException;
import lakshya.model.Car;
import lakshya.service.CarService;

//restControllers automatically returns json 
@RestController
public class CarController {
	private final CarService carService;
	
	 @Autowired
	 CarController(CarService carService) {
			this.carService = carService;
			
		}
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/priceOfCar", consumes = {"application/json" })
	   	public @ResponseBody Car cPriceInfo(@RequestBody Car car) throws Exception {
	    	System.out.println("inside car price info , value of input is :"+car.toString());
	    	int rateOfDollarInINR = 60;
	    	Random r = new Random();
	    	
	    	/*
	    	 * =======================
	    	 * create dummy data starts
	    	 * 
	    	 * */  
	    
	    	Car cc1  = new Car();
	    	cc1.setManufacturer("Fiat");
	    	cc1.setModel("Punto");
	    	cc1.setPrimaryPriceUnitValue(12000);
	    	cc1.setSecondaryPriceUnitValue(cc1.getPrimaryPriceUnitValue() * rateOfDollarInINR);
	    	carService.saveCar(cc1);
	    	
	    	Car cc2  = new Car();
	    	cc2.setManufacturer("Fiat");
	    	cc2.setModel("Linea");
	    	cc2.setPrimaryPriceUnitValue(13000);
	    	cc2.setSecondaryPriceUnitValue(cc2.getPrimaryPriceUnitValue() * rateOfDollarInINR);
	    	carService.saveCar(cc2);
	    	
	    	Car cc3  = new Car();
	    	cc3.setManufacturer("Ford");
	    	cc3.setModel("EcoSport");
	    	cc3.setPrimaryPriceUnitValue(14000);
	    	cc3.setSecondaryPriceUnitValue(cc3.getPrimaryPriceUnitValue() * rateOfDollarInINR);
	    	carService.saveCar(cc3);
	    	
	    	Car cc4  = new Car();
	    	cc4.setManufacturer("Ford");
	    	cc4.setModel("Figo");
	    	cc4.setPrimaryPriceUnitValue(r.nextInt(10000));
	    	cc4.setSecondaryPriceUnitValue(cc4.getPrimaryPriceUnitValue() * rateOfDollarInINR);
	    	carService.saveCar(cc4);
	    	
	    	Car cc5  = new Car();
	    	cc5.setManufacturer("Toyota");
	    	cc5.setModel("Etios");
	    	cc5.setPrimaryPriceUnitValue(r.nextInt(8000));
	    	cc5.setSecondaryPriceUnitValue(cc5.getPrimaryPriceUnitValue() * rateOfDollarInINR);
	    	carService.saveCar(cc5);
	    	
	    	Car cc6  = new Car();
	    	cc6.setManufacturer("Toyota");
	    	cc6.setModel("Fortuner");
	    	cc6.setPrimaryPriceUnitValue(r.nextInt(50000));
	    	cc6.setSecondaryPriceUnitValue(cc6.getPrimaryPriceUnitValue() * rateOfDollarInINR);
	    	carService.saveCar(cc6);
	    	
	    	Car cc7  = new Car();
	    	cc7.setManufacturer("Toyota");
	    	cc7.setModel("Altias");
	    	cc7.setPrimaryPriceUnitValue(r.nextInt(20000));
	    	cc7.setSecondaryPriceUnitValue(cc7.getPrimaryPriceUnitValue() * rateOfDollarInINR);
	    	carService.saveCar(cc7);
	    	
	    	/*
	    	 * =======================
	    	 * create dummy data ends
	    	 * */ 
	    	if(carService.findByManufacturerAndModel(car.getManufacturer(),car.getModel()).size() >= 1){
	    		return carService.findByManufacturerAndModel(car.getManufacturer(),car.getModel()).get(0);
	    	}else{
	    		System.out.println("did not found any match returning null");
	    		throw new CarNotFoundException("LocalException : Model and manufacturer not found");
	    		//return null;
	    	}
	    }
	 
	 @ExceptionHandler(CarNotFoundException.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception ex) {
	    System.out.println("local Exception handler called");
		ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", ex);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	  }
	 
}
