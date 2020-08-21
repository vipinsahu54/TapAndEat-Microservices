package com.tapandeat.foodtray.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tapandeat.foodtray.model.Cuisine;
import com.tapandeat.foodtray.model.Items;

@FeignClient(value="RESTAURANT-SERVICE", fallback=RestaurantServiceFallback.class)
public interface RestaurantService {

	@RequestMapping(method=RequestMethod.GET, value="/items")
	List<Items> findAllItems();
	
	@RequestMapping(method=RequestMethod.GET, value="/items/cuisine/{cuisineName}")
	List<Items> findItemsByCuisineName(@PathVariable("cuisineName") String cuisineName);
	
	@RequestMapping(method=RequestMethod.GET, value="/items/{id}")
	Items findItemById(@PathVariable("id")Long id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/items")
	void saveItems(@RequestBody Items item);
	
	@RequestMapping(method=RequestMethod.GET, value="/cuisine")
	List<Cuisine> findAllCuisine();
	
	@RequestMapping(method=RequestMethod.GET, value="/cuisine/{id}")
	Items findCuisineById(@PathVariable("id")Long id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/cuisine")
	void saveCuisine(@RequestBody Cuisine cuisine);
	
}
