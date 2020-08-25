package com.tapandeat.account.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapandeat.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
