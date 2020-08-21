package com.tapandeat.foodtray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tapandeat.foodtray.model.Store;
import com.tapandeat.foodtray.service.CustomerService;
import com.tapandeat.foodtray.service.RestaurantService;
import com.tapandeat.foodtray.service.StoreService;

/**
 * Main controller used for accessing the application
 * 
 * @author vipin sahu
 *
 */
@RestController
public class FoodTrayController {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/stores/{id}")
	public Store getStoreById(@PathVariable("id") Long id) {
		return storeService.findById(id);
	}
	
	@GetMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView model= new ModelAndView();
		model.addObject("stores",storeService.findAll());
		model.addObject("customers", customerService.findAll());
		model.addObject("items", restaurantService.findAllItems());
		model.setViewName("index");
		return model;
	}
	
	@GetMapping(value = "/menu")
	public ModelAndView menu() {
		ModelAndView model= new ModelAndView();
		model.addObject("stores",storeService.findAll());
		model.addObject("customers", customerService.findAll());
		model.addObject("items", restaurantService.findAllItems());
		model.addObject("cuisines", restaurantService.findAllCuisine());
		model.setViewName("Menu");
		return model;
	}
}
