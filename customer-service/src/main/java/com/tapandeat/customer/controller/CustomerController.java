package com.tapandeat.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tapandeat.customer.model.Customer;
import com.tapandeat.customer.service.CustomerRepositoryService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepositoryService customerService;
	
	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping(value = "/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id) {
		return customerService.getById(id);
	}
	
	@PostMapping(value = "/customers")
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
}
