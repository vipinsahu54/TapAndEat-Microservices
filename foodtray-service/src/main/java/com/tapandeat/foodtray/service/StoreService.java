package com.tapandeat.foodtray.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tapandeat.foodtray.model.Store;

@FeignClient(value="STORE-SERVICE", fallback=StoreServiceFallback.class)
public interface StoreService {

	@RequestMapping(method = RequestMethod.GET, value = "/stores")
	public List<Store> findAll();
	
	@RequestMapping(method = RequestMethod.GET, value = "/stores/{id}")
	public Store findById(@PathVariable("id") Long id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/stores")
	public void saveStore(@RequestBody Store store);
}
