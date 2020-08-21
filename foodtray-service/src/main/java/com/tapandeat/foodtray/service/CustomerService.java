package com.tapandeat.foodtray.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tapandeat.foodtray.model.Customer;

@FeignClient(value="CUSTOMER-SERVICE", fallback=CustomerServiceFallback.class)
public interface CustomerService {

	@RequestMapping(method = RequestMethod.GET ,value = "/customers")
	public List<Customer> findAll();
	
	@RequestMapping(method = RequestMethod.GET ,value = "/customers/{id}")
	public Customer findById(@PathVariable("id") Long id);
	
	@RequestMapping(method = RequestMethod.POST ,value = "/customers")
	public void findById(@RequestBody Customer customer);
}
