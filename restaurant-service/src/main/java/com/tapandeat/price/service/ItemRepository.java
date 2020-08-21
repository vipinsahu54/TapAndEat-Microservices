package com.tapandeat.price.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapandeat.price.model.Items;

public interface ItemRepository extends JpaRepository<Items, Long>{
	
}
