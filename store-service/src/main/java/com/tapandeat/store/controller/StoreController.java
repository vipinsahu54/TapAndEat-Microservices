package com.tapandeat.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tapandeat.store.model.Store;
import com.tapandeat.store.service.StoreRepositoryService;

@RestController
public class StoreController {
	
	@Autowired
	private StoreRepositoryService storeRepository;

	@GetMapping(value = "/stores")
	public List<Store> getAllStores(){
		return storeRepository.findAllStores();
	}
	
	@GetMapping(value = "/stores/{id}")
	public Store getAllStores(@PathVariable("id")Long id){
		return storeRepository.findById(id);
	}
	
	@PostMapping(value = "/stores")
	public void saveStore(@RequestBody Store store) {
		storeRepository.saveStore(store);
	}
}
