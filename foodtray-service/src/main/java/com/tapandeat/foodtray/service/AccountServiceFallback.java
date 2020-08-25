package com.tapandeat.foodtray.service;

import java.util.List;

import com.tapandeat.foodtray.model.Account;
import com.tapandeat.foodtray.model.Login;

public class AccountServiceFallback implements AccountService {

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountByUserName(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateUser(Login login) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
