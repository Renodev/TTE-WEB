package com.rnc.dev.web.beans;

import java.io.Serializable;

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
	
	private Continent [] continents;
	
	@Inject
	private CountryService countryService;
	
	@PostConstruct
	public void initialize () {
		country = new Country();
		continents = Continent.values();
	}

	public void save () {
		countryService.save(country);
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
	
}