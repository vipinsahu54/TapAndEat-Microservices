package com.tapandeat.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tapandeat.store.model.Store;

@Service
public class StoreRepositoryService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> findAllStores(){
		return storeRepository.findAll();
	}
	
	public Store findById(Long id) {
		return storeRepository.findById(id).get();
	}
	
	public void saveStore(Store store) {
		storeRepository.save(store);
	}
}
