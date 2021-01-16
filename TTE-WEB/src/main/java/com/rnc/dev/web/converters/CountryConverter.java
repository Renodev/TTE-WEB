package com.rnc.dev.web.converters;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Country;
import com.rnc.dev.web.repositories.CountryRepository;

@Named
@Dependent
public class CountryConverter implements Converter<Country> {

	@Inject
	private CountryRepository countryRepository;
	
	@Override
	public Country getAsObject(FacesContext context, UIComponent component, String value) {
//		long id = Long.parseLong(value);
//		Country country = countryRepository.findByID(id);
//		return country;
		return countryRepository.findByID(Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Country value) {
		Country country = (Country) value;
		long id = country.getId();
		String sid = String.valueOf(id);
		return sid;
		//return String.valueOf(((Country)value).getId());
	}

}
