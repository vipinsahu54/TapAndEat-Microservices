package com.tapandeat.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tapandeat.account.model.Account;
import com.tapandeat.account.model.Login;
import com.tapandeat.account.service.AccountRepositoryService;

@RestController
public class AccountController {

	@Autowired
	private AccountRepositoryService accountService;
	
	@GetMapping(value = "/account")
	public List<Account> getAllAccounts(){
		return accountService.findAll();
	}

	@GetMapping(value = "/account/{id}")
	public Account getAccountById(@PathVariable("id") Long id) {
		return accountService.getById(id);
	}
	
	@GetMapping(value = "/account/email/{email}")
	public Account getAccountByEmail(@PathVariable("email") String email) {
		return accountService.getByEmail(email);
	}
	
	@GetMapping(value = "/account/user/{user}")
	public Account getAccountByUserName(@PathVariable("user") String user) {
		return accountService.getByUserName(user);
	}
	
	@PostMapping(value = "/account")
	public void saveAccount(@RequestBody Account account) {
		accountService.save(account);
	}
	
	@PostMapping(value = "/account/validate")
	public boolean validateUser(@RequestBody Login login) {
		return accountService.validateUser(login);
	}
}