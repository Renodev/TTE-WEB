package com.rnc.dev.web.repositories;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import com.rnc.dev.web.entities.Vehicle;

public class VehicleRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (Vehicle vehicle) {
		entityManager.persist(vehicle);
	}
	
	
	

}
