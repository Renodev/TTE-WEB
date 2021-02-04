package com.rnc.dev.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.dev.web.entities.TourPackage;





public class TourPackageReposity {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (TourPackage tourPackage) {
		entityManager.persist(tourPackage);
	}
	public void update(TourPackage tourPackage) {
		entityManager.merge(tourPackage);
	}
	public List<TourPackage> findAll(){
		String query = "select t from %s t where t.erase = false";
		String sql = String.format(query, TourPackage.class.getSimpleName());
		TypedQuery<TourPackage> typeQuery = entityManager.createQuery(sql,TourPackage.class);
		return typeQuery.getResultList();
		
	}

}
