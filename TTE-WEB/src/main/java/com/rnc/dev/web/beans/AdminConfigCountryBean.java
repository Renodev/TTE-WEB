package com.rnc.dev.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Country;
import com.rnc.dev.web.enums.Continent;
import com.rnc.dev.web.services.CountryService;

@Named
@ViewScoped
public class AdminConfigCountryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Country country;
	
	private List<Country> countries;
	
	private Continent [] continents;
	
	@Inject
	private CountryService countryService;
	
	@PostConstruct
	public void initialize () {
		country = new Country();
		continents = Continent.values();
		countries = countryService.findAll();
	}
	
	public void save () {
		countryService.save(country);
		initialize();
	}
	
	public void update (Country country) {
		this.country = country;
	}
	
	public void delete (Country country) {
		countryService.delete(country);
		initialize();
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Continent[] getContinents() {
		return continents;
	}

	public void setContinents(Continent[] continents) {
		this.continents = continents;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
}