package com.rnc.dev.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Country;
import com.rnc.dev.web.entities.Hotel;
import com.rnc.dev.web.entities.State;
import com.rnc.dev.web.enums.HotelStatus;
import com.rnc.dev.web.services.CountryService;
import com.rnc.dev.web.services.HotelService;
import com.rnc.dev.web.services.StateService;

@Named
@ViewScoped
public class AdminConfigHotelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Hotel hotel;
	
	private Country country;
	
	private List<Hotel> hotels;
	
	private List<Country> countries;
	
	private List<State> states;
	
	private HotelStatus [] hotelStatuses;
	
	@Inject
	private HotelService hotelService;
	
	@Inject
	private CountryService countryService;
	
	@Inject
	private StateService stateService;
	
	@PostConstruct
	public void initialize () {
		hotel = new Hotel();
		hotels = hotelService.findAll();
		countries = countryService.findAll();
		states = stateService.findAll();
		hotelStatuses = HotelStatus.values();
	}
	
	public void updateState () {
		states = stateService.findByCountry(country);
	}
	
	public void save () {
		hotelService.save(hotel);
		initialize();
	}
	
	public void update (Hotel hotel) {
		this.hotel = hotel;
	}
	
	public void delete (Hotel hotel) {
		hotelService.delete(hotel);
		initialize();
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public HotelStatus[] getHotelStatuses() {
		return hotelStatuses;
	}

	public void setHotelStatuses(HotelStatus[] hotelStatuses) {
		this.hotelStatuses = hotelStatuses;
	}
	
}