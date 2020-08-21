package com.tapandeat.price.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tapandeat.price.model.Items;
import com.tapandeat.price.service.ItemRepositoryService;

@RestController
public class ItemController {

	@Autowired
	private ItemRepositoryService itemRepositoryService;
	
	@GetMapping(value = "/items")
	public List<Items> getAllitems() {
		return itemRepositoryService.findAll();
	}
	
	@GetMapping(value = "/items/{id}")
	public Items getById(@PathVariable("id") Long id) {
		return itemRepositoryService.findById(id);
	}
	
	@GetMapping(value = "/items/cuisine/{cuisineName}")
	public List<Items> getItemsByCuisineName(@PathVariable("cuisineName") String cuisineName) {
		return itemRepositoryService.findByCuisine(cuisineName);
	}
	
	@PostMapping(value = "/items")
	public void saveItem(@RequestBody Items item) {
		itemRepositoryService.saveItem(item);
	}
}
