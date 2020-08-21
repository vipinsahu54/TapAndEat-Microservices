package com.tapandeat.foodtray.service;

import java.util.List;

import com.tapandeat.foodtray.model.Cuisine;
import com.tapandeat.foodtray.model.Items;

public class RestaurantServiceFallback implements RestaurantService{

	@Override
	public List<Items> findAllItems() {
		return null;
	}

	@Override
	public Items findItemById(Long id) {
		return null;
	}
	
	@Override
	public List<Items> findItemsByCuisineName(String cuisineName) {
		return null;
	}

	@Override
	public void saveItems(Items item) {
	}

	@Override
	public List<Cuisine> findAllCuisine() {
		return null;
	}

	@Override
	public Items findCuisineById(Long id) {
		return null;
	}

	@Override
	public void saveCuisine(Cuisine cuisine) {
	}
	
}
