package com.tapandeat.price.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tapandeat.price.model.Items;

@Service
public class ItemRepositoryService {

	@Autowired
	ItemRepository itemRepository;
	
	public Items findById(Long id) {
		return itemRepository.findById(id).get();
	}
	
	public List<Items> findAll() {
		return itemRepository.findAll();
	}
	
	public List<Items> findByCuisine(String cuisineName){
		List<Items> items= itemRepository.findAll();
		return items.stream().filter(item->item.getCuisine().getName().equalsIgnoreCase(cuisineName)).collect(Collectors.toList());
	}
	
	public void saveItem(Items items) {
		itemRepository.save(items);
	}
}
