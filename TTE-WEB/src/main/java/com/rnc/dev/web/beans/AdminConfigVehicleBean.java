package com.rnc.dev.web.beans;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Vehicle;
import com.rnc.dev.web.enums.VehicleType;
import com.rnc.dev.web.services.VehicleService;

@Named
@ViewScoped
public class AdminConfigVehicleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Vehicle vehicle;
	
    public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleType[] getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(VehicleType[] vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	private VehicleType [] vehicleTypes;


	@Inject
	private VehicleService vehicleService;
	
	@PostConstruct
	public void initialize () {
		vehicle = new Vehicle();
		vehicleTypes = VehicleType.values();
	}

	public void save () {
		vehicleService.save(vehicle);
		initialize();
	}

	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
}