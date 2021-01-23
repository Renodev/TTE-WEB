package com.rnc.dev.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.dev.web.entities.Country;
import com.rnc.dev.web.entities.State;

public class StateRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (State state) {
		entityManager.persist(state);
	}
	
	public void update (State state) {
		entityManager.merge(state);
	}
	
	public void delete (State state) {
		entityManager.remove(state);
	}
	
	public State findByID (long id) {
		String query = "select t from %s t where t.id = "+id;
		String sql = String.format(query, State.class.getSimpleName());
		TypedQuery<State> typedQuery = entityManager.createQuery(sql, State.class);
		try {
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<State> findByCountry (Country country) {
		String query = "select t from %s t where t.erase = false and t.country.id = "+country.getId();
		String sql = String.format(query, State.class.getSimpleName());
		TypedQuery<State> typedQuery = entityManager.createQuery(sql, State.class);
		return typedQuery.getResultList();
	}
	
	public List<State> findAll() {
		String query = "select t from %s t where t.erase = false";
		String sql = String.format(query, State.class.getSimpleName());
		TypedQuery<State> typedQuery = entityManager.createQuery(sql, State.class);
		return typedQuery.getResultList();
	}
	
}
