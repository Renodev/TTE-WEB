package com.rnc.dev.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Hotel;
import com.rnc.dev.web.entities.State;
import com.rnc.dev.web.entities.TourImage;
import com.rnc.dev.web.entities.TourPackage;
import com.rnc.dev.web.entities.Vehicle;
import com.rnc.dev.web.services.HotelService;
import com.rnc.dev.web.services.StateService;
import com.rnc.dev.web.services.TourImageService;
import com.rnc.dev.web.services.TourPackageService;







@Named
@ViewScoped
public class TourPackageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private TourPackage tourPackage;
	private TourImage tourImage;
	private List<TourPackage> tourPackages;
	private List<TourImage> tourImages;
	
	private List<State> states;
	private List<Hotel> hotels;
	private List<Vehicle> vehicles;
	@Inject
	private StateService stateService;
	@Inject
	private TourImageService tourImageService;
	
	@Inject
	private HotelService hotelService;
	//@Inject 
	//private VehicleService vehicleService;
	@Inject
	private TourPackageService tourPackageService;
	
	@PostConstruct
	public void initialize() {
		tourPackage = new TourPackage();
		tourImage = new TourImage();
		tourPackages = tourPackageService.findAll();
		
		
		tourImages = tourImageService.findAll();
		//vehicles = new ArrayList<Vehicle>();
		//List<Vehicle> lis = vehicleService.findAll();
		//for(int v = lis.size()-1;v>-1;--v) {
			//vehicles.add(lis.get(v));
		//}
		states = new ArrayList<State>();
		List<State> lists = stateService.findAll();
		for(int s = lists.size()-1; s>-1;--s) {
			states.add(lists.get(s));
		}
		hotels = new ArrayList<Hotel>();
		List<Hotel> list = hotelService.findAll();
		for(int i = list.size()-1;i>-1;--i) {
			hotels.add(list.get(i));
		}
		
		
	}
	public void save() {
		tourPackageService.save(tourPackage);
		
		initialize();
	}
	public void update(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}
	public void delete(TourPackage tourPackage) {
		tourPackageService.delete(tourPackage);
		initialize();
	}
	public TourPackage getTourPackage() {
		return tourPackage;
	}
	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}
	public List<TourPackage> getTourPackages() {
		return tourPackages;
	}
	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public List<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public List<TourImage> getTourImages() {
		return tourImages;
	}
	public void setTourImages(List<TourImage> tourImages) {
		this.tourImages = tourImages;
	}
	public TourImage getTourImage() {
		return tourImage;
	}
	public void setTourImage(TourImage tourImage) {
		this.tourImage = tourImage;
	}
	
	
	
	
	
	
	}
