package com.tapandeat.customer.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapandeat.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
