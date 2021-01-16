package com.rnc.dev.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rnc.dev.web.entities.Country;
import com.rnc.dev.web.entities.State;
import com.rnc.dev.web.services.CountryService;
import com.rnc.dev.web.services.StateService;

@Named
@ViewScoped
public class AdminConfigStateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private State state;
	
	private List<Country> countries;
	
	private List<State> states;
	
	@Inject
	private StateService stateService;
	
	@Inject
	private CountryService countryService;
	
	@PostConstruct
	public void initialize () {
		state = new State();
		states = stateService.findAll();
		countries = new ArrayList<Country>();
		List<Country> list = countryService.findAll();
		for (int i = list.size() - 1; i > -1; --i) {
			countries.add(list.get(i));
		}
	}
	
	public void save () {
		stateService.save(state);
		initialize();
	}
	
	public void update (State state) {
		this.state = state;
	}
	
	public void delete (State state) {
		stateService.delete(state);
		initialize();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
}