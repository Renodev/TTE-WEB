package com.rnc.dev.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.dev.web.entities.Hotel;





public class HotelReposity {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (Hotel hotel) {
		entityManager.persist(hotel);
	}
	public void update(Hotel hotel) {
		entityManager.merge(hotel);
	}
	public Hotel findByID (long id) {
		String query = "select t from %s t where t.erase = false and t.id = "+id;
		String sql = String.format(query, Hotel.class.getSimpleName());
		TypedQuery<Hotel> typedQuery = entityManager.createQuery(sql, Hotel.class);
		try {
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	public List<Hotel> findAll(){
		String query = "select t from %s t where t.erase = false";
		String sql = String.format(query, Hotel.class.getSimpleName());
		TypedQuery<Hotel> typeQuery = entityManager.createQuery(sql,Hotel.class);
		return typeQuery.getResultList();
		
	}
	

}
