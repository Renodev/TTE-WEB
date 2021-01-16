package com.rnc.dev.web.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.dev.web.entities.Country;
import com.rnc.dev.web.repositories.CountryRepository;

@LocalBean
@Stateless
public class CountryService {
	
	@Inject
	private CountryRepository countryRepository;

	public void save (Country country) {
		if (country.getId() == 0) {
			countryRepository.save(country);
		} else {
			update(country);
		}
		
	}
	
	public void update (Country country) {
		countryRepository.update(country);
	}

	public void delete (Country country) {
		country.setErase(true);
		update(country);
	}
	
	public List<Country> findAll () {
		return countryRepository.findAll();
	}
	
}
