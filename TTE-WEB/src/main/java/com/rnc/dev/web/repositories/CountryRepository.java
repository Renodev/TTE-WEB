package com.rnc.dev.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.dev.web.entities.Country;

public class CountryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (Country country) {
		entityManager.persist(country);
	}
	
	public void update (Country country) {
		entityManager.merge(country);
	}
	
	public void delete (Country country) {
		entityManager.remove(country);
	}
	
	public Country findByID (long id) {
		String query = "select t from %s t where t.erase = false and t.id = "+id;
		String sql = String.format(query, Country.class.getSimpleName());
		TypedQuery<Country> typedQuery = entityManager.createQuery(sql, Country.class);
		try {
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<Country> findAll () {
		String query = "select t from %s t where t.erase = false"; // select * from country;
		String sql = String.format(query, Country.class.getSimpleName()); // select Country from Country;
		TypedQuery<Country> typeQuery = entityManager.createQuery(sql, Country.class);
		return typeQuery.getResultList();
	}

}
