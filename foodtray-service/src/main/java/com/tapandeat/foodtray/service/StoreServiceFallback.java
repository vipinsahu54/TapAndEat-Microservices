package com.tapandeat.foodtray.service;

import java.util.List;

import com.tapandeat.foodtray.model.Store;

public class StoreServiceFallback implements StoreService{

	@Override
	public List<Store> findAll() {
		return null;
	}

	@Override
	public Store findById(Long id) {
		return null;
	}

	@Override
	public void saveStore(Store store) {
		
	}

}
