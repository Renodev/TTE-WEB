package com.rnc.dev.web.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rnc.dev.web.entities.Country;

public class CountryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (Country country) {
		entityManager.persist(country);
	}

}
