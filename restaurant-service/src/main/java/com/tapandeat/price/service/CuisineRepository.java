package com.tapandeat.price.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapandeat.price.model.Cuisine;

public interface CuisineRepository extends JpaRepository<Cuisine, Long>{

}
