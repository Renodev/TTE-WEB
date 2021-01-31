package com.rnc.dev.web.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.dev.web.entities.Account;

public class AccountRepository {

	@PersistenceContext
	private EntityManager entitymanganer;
	
	public void save(Account account) {
		entitymanganer.persist(account);
	}
	
	public Account findByPhoneAndPassword (String phone, String password) {
		String sql = "select a from %s a where a.phone = '"+
		phone+"' and a.password = '"+password+"' and a.erase = false";
		String query = String.format(sql, Account.class.getSimpleName());
		TypedQuery<Account> typedQuery = entitymanganer.createQuery(query, Account.class);
		try {
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
