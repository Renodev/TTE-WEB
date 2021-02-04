package com.rnc.dev.web.converters;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Hotel;
import com.rnc.dev.web.repositories.HotelReposity;



@Named
@Dependent
public class HotelConverter implements Converter<Hotel>{
	@Inject
	private HotelReposity hotelReposity;

	@Override
	public Hotel getAsObject(FacesContext context, UIComponent component, String value) {
		long id = Long.parseLong(value);
		Hotel hotel = hotelReposity.findByID(id);
		return hotel;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Hotel value) {
		return String.valueOf(((Hotel)value).getId());
	}
	

}
