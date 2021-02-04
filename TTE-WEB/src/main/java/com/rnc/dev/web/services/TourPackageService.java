package com.rnc.dev.web.services;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.dev.web.entities.TourPackage;
import com.rnc.dev.web.repositories.TourPackageReposity;







@LocalBean
@Stateless
public class TourPackageService {
	@Inject
	private TourPackageReposity tourPackageReposity;
	public void save(TourPackage tourPackage) {
		if (tourPackage.getId()==0) {
			tourPackageReposity.save(tourPackage);
			}else {
				update(tourPackage);
			}
	}
	public List<TourPackage> findAll(){
		return tourPackageReposity.findAll();
		}
	public void update(TourPackage tourPackage) {
		tourPackageReposity.update(tourPackage);
	}
	public void delete(TourPackage tourPackage) {
		tourPackage.setErase(true);
		update(tourPackage);
	}
}
	
	
	
	


