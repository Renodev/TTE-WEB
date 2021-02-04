package com.rnc.dev.web.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.dev.web.entities.TourImage;
import com.rnc.dev.web.repositories.TourImageReposity;




@LocalBean
@Stateless
public class TourImageService {
	@Inject
	private TourImageReposity tourImageReposity;
	public void save(TourImage tourImage) {
		if (tourImage.getId()==0) {
			tourImageReposity.save(tourImage);
			}else {
				update(tourImage);
			}
	}
	
	public List<TourImage> findAll(){
		return tourImageReposity.findAll();
		}
	public void update(TourImage tourImage) {
		tourImageReposity.update(tourImage);
	}
	public void delete(TourImage tourImage) {
		tourImage.setErase(true);
		update(tourImage);
	}
	

}
