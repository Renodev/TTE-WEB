package com.rnc.dev.web.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.dev.web.entities.State;
import com.rnc.dev.web.repositories.StateRepository;

@LocalBean
@Stateless
public class StateService {
	
	@Inject
	private StateRepository stateRepository;
	
	public void save (State state) {
		if (state.getId() == 0) {
			stateRepository.save(state);
		} else {
			update(state);
		}
	}
	
	public void update (State state) {
		stateRepository.update(state);
	}
	
	public void delete (State state) {
		state.setErase(true);
		update(state);
	}
	
	public List<State> findAll () {
		return stateRepository.findAll();
	}

}
