package com.tapandeat.store;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.tapandeat.store.model.Store;
import com.tapandeat.store.service.StoreRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class StoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceApplication.class, args);
	}

	@Autowired
	StoreRepository storeRepository;
	
	@PostConstruct
	public void init() {
		Store store= new Store();
		store.setLocation("New York");
		store.setStoreName("Tap And Eat");
		store.setBranchName("Tap And Eat NYC");
		store.setAddress("5th flora, 700/D kings road, green lane New York");
		store.setEmail("info@tapAndEat.com");
		store.setPhone("+10 378 483 6782");
		store.setPostalCode("1782");
		
		storeRepository.save(store);
	}
}
