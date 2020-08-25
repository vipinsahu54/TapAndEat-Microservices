package com.tapandeat.foodtray.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tapandeat.foodtray.model.Account;
import com.tapandeat.foodtray.model.Login;

@FeignClient(value="ACCOUNT-SERVICE", fallback=AccountServiceFallback.class)
public interface AccountService {
	
	@GetMapping(value = "/account")
	public List<Account> findAll();

	@GetMapping(value = "/account/{id}")
	public Account getAccountById(@PathVariable("id") Long id);
	
	@GetMapping(value = "/account/email/{email}")
	public Account getAccountByEmail(@PathVariable("email") String email);
	
	@GetMapping(value = "/account/user/{user}")
	public Account getAccountByUserName(@PathVariable("user") String user);
	
	@PostMapping(value = "/account")
	public void saveAccount(@RequestBody Account account);
	
	@PostMapping(value = "/account/validate")
	public boolean validateUser(@RequestBody Login login);
}
