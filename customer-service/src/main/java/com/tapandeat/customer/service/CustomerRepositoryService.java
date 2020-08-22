package com.tapandeat.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tapandeat.customer.model.Customer;

@Service
public class CustomerRepositoryService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Customer getById(Long id) {
		return customerRepository.getOne(id);
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
}
