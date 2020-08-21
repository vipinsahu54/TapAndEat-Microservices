package com.tapandeat.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tapandeat.price.model.Cuisine;

@Service
public class CuisineRepositoryService {

	@Autowired
	private CuisineRepository cuisineRepository;
	
	public List<Cuisine> findAll(){
		return cuisineRepository.findAll();
	}
	
	public Cuisine findById(Long id) {
		return cuisineRepository.findById(id).get();
	}
	
	public void saveCuisine(Cuisine cuisine) {
		cuisineRepository.save(cuisine);
	}
}
