package com.tapandeat.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tapandeat.account.model.Account;
import com.tapandeat.account.model.Login;

@Service
public class AccountRepositoryService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account getById(Long id) {
		Optional<Account> findById = accountRepository.findById(id);
		return (findById.isPresent())? findById.get(): null;
	}

	public Account getByEmail(String email) {
		Optional<Account> findFirst = accountRepository.findAll().stream().filter(account -> account.getEmail().equalsIgnoreCase(email)).findFirst();
		if(findFirst.isPresent())
			return findFirst.get();
		else
			return null;
	}

	public Account getByUserName(String userName) {
		Optional<Account> findFirst = accountRepository.findAll().stream().filter(account -> account.getUserName().equalsIgnoreCase(userName)).findFirst();
		if (findFirst.isPresent())
			return findFirst.get();
		else
			return null;
	}

	public void save(Account account) {
		accountRepository.save(account);
	}

	public boolean validateUser(Login login) {
		Account account;
		if (login.getUserName().contains(".com") && login.getUserName().contains("@")) {
			account = getByEmail(login.getUserName());
		} else {
			account = getByUserName(login.getUserName());
		}

		return (account.getPassword().equalsIgnoreCase(login.getPassword()));
	}
}
