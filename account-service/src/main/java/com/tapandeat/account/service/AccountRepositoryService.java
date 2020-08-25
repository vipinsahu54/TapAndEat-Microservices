package com.tapandeat.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tapandeat.account.model.Account;
import com.tapandeat.account.model.Login;

@Service
public class AccountRepositoryService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> findAll(){
		return accountRepository.findAll();
	}
	
	public Account getById(Long id) {
		return accountRepository.findById(id).get();
	}
	
	public Account getByEmail(String email) {
		return accountRepository.findAll().stream().filter(account -> account.getEmail().equalsIgnoreCase(email)).findFirst().get();
	}
	
	public Account getByUserName(String userName) {
		return accountRepository.findAll().stream().filter(account -> account.getUserName().equalsIgnoreCase(userName)).findFirst().get();
	}
	
	public void save(Account account) {
		accountRepository.save(account);
	}

	public boolean validateUser(Login login) {
		Account account;
		if(login.getUserName().contains(".com") &&  login.getUserName().contains("@")) {
			account=getByEmail(login.getUserName());
		}
		else {
			account=getByUserName(login.getUserName());
		}
		
		if(account.getPassword().equalsIgnoreCase(login.getPassword()))
			return true;
		
		return false;
	}
}
