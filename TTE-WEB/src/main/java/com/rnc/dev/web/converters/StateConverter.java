package com.rnc.dev.web.converters;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.State;
import com.rnc.dev.web.repositories.StateRepository;

@Named
@Dependent
public class StateConverter implements Converter<State> {
	
	@Inject
	private StateRepository stateRepository;

	@Override
	public State getAsObject(FacesContext context, UIComponent component, String value) {
		return stateRepository.findByID(Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, State value) {
		return String.valueOf(((State)value).getId());
	}

}
