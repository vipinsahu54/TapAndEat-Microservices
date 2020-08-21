package com.tapandeat.price.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tapandeat.price.model.Cuisine;
import com.tapandeat.price.service.CuisineRepositoryService;

@RestController
public class CuisineController {

	@Autowired
	private CuisineRepositoryService cuisineRepositorySerice;
	
	@GetMapping(value = "/cuisine")
	public List<Cuisine> getAllCuisine(){
		return cuisineRepositorySerice.findAll();
	}
	
	@GetMapping(value = "/cuisine/{id}")
	public Cuisine getById(@PathVariable("id")Long id) {
		return cuisineRepositorySerice.findById(id);
	}
	
	@PostMapping(value = "/cuisine")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void saveCuisine(@RequestBody Cuisine cuisine) {
		cuisineRepositorySerice.saveCuisine(cuisine);
	}
}
