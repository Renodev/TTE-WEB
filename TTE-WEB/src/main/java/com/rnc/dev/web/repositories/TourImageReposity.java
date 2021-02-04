package com.rnc.dev.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.dev.web.entities.TourImage;




public class TourImageReposity {
	@PersistenceContext
	private EntityManager entityManager;
	public void save(TourImage tourImage) {
		entityManager.persist(tourImage);
	}
	public void update(TourImage tourImage) {
		entityManager.merge(tourImage);
	}
	
	public List<TourImage> findAll(){
		String query = "select t from %s t where t.erase = false";
		String sql = String.format(query, TourImage.class.getSimpleName());
		TypedQuery<TourImage> typeQuery = entityManager.createQuery(sql,TourImage.class);
		return typeQuery.getResultList();
		
	}

}
