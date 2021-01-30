package com.rnc.dev.web.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.dev.web.entities.Account;
import com.rnc.dev.web.repositories.AccountRepository;

@LocalBean
@Stateless
public class AccountService {
	
	
	@Inject
	private AccountRepository accountrepository;
	
	public void save(Account account) {
		
		accountrepository.save(account);
	}


}
