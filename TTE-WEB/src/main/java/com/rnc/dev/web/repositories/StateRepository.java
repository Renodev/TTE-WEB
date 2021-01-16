package com.rnc.dev.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public List<State> findAll() {
		String query = "select t from %s t where t.erase = false";
		String sql = String.format(query, State.class.getSimpleName());
		TypedQuery<State> typedQuery = entityManager.createQuery(sql, State.class);
		return typedQuery.getResultList();
	}
	
}
