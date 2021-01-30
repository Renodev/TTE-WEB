package com.rnc.dev.web.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rnc.dev.web.entities.Account;

public class AccountRepository {

	@PersistenceContext
	private EntityManager entitymanganer;
	
	public void save(Account account) {
		
		entitymanganer.persist(account);
		
	}
}
