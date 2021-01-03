package com.rnc.dev.web.services;

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
		countryRepository.save(country);
	}

}
