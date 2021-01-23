package com.rnc.dev.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.dev.web.entities.Hotel;

public class HotelRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (Hotel hotel) {
		entityManager.persist(hotel);
	}
	
	public void update (Hotel hotel) {
		entityManager.merge(hotel);
	}
	
	public void delete (Hotel hotel) {
		entityManager.remove(hotel);
	}
	
	public List<Hotel> findAll () {
		String sql = String.format("select t from %s t where t.erase = false", Hotel.class.getSimpleName());
		TypedQuery<Hotel> typedQuery = entityManager.createQuery(sql, Hotel.class);
		return typedQuery.getResultList();
	}

}
