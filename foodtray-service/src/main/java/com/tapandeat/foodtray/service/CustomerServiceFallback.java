package com.tapandeat.foodtray.service;

import java.util.List;

import com.tapandeat.foodtray.model.Customer;

public class CustomerServiceFallback implements CustomerService{

	@Override
	public List<Customer> findAll() {
		return null;
	}

	@Override
	public Customer findById(Long id) {
		return null;
	}

	@Override
	public void findById(Customer customer) {
		
	}

}
