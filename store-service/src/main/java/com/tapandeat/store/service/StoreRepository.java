package com.tapandeat.store.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapandeat.store.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{

}
