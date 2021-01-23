package com.rnc.dev.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.dev.web.entities.Hotel;
import com.rnc.dev.web.repositories.HotelRepository;

@LocalBean
@Stateless
public class HotelService {
	
	@Inject
	private HotelRepository hotelRepository;

	public void save (Hotel hotel) {
		if (hotel.getId() != 0) {
			update(hotel);
		} else {
			hotelRepository.save(hotel);
		}
	}
	
	public void update (Hotel hotel) {
		hotelRepository.update(hotel);
	}
	
	public void delete (Hotel hotel) {
		hotel.setErase(true);
		update(hotel);
	}
	
	public List<Hotel> findAll () {
		List<Hotel> hotels = new ArrayList<Hotel>();
		List<Hotel> list = hotelRepository.findAll();
		for (int i = list.size() - 1; i > -1; --i) {
			hotels.add(list.get(i));
		}
		return hotels;
	}
	
}







