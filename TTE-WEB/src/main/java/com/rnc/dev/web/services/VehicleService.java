package com.rnc.dev.web.services;




import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;


import com.rnc.dev.web.entities.Vehicle;
import com.rnc.dev.web.repositories.VehicleRepository;

@LocalBean
@Stateless
public class VehicleService {
	
	@Inject
	private VehicleRepository  vehicleRepository;
	
	public void save (Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	


}
