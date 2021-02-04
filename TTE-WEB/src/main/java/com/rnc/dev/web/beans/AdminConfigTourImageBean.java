package com.rnc.dev.web.beans;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.rnc.dev.web.entities.TourImage;
import com.rnc.dev.web.services.TourImageService;


@Named
@ViewScoped
public class AdminConfigTourImageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private TourImage tourImage;
	private Part image;
	private List<TourImage> tourImages;
	@Inject
	private TourImageService tourImageService;
	@PostConstruct
	public void initialize() {
		tourImage = new TourImage();
		
		tourImages = tourImageService.findAll();
		
		
		}
	public void save() {
		tourImageService.save(tourImage);
		initialize();
	}
	public void update(TourImage tourImage) {
		this.tourImage = tourImage;
	}
	public void delete(TourImage tourImage) {
		tourImageService.delete(tourImage);
		initialize();
	}
	
	public Part getImage() {
		return image;
	}
	public void setImage(Part image) {
		this.image = image;
	}
	public TourImage getTourImage() {
		return tourImage;
	}
	public void setTourImage(TourImage tourImage) {
		this.tourImage = tourImage;
	}
	public List<TourImage> getTourImages() {
		return tourImages;
	}
	public void setTourImages(List<TourImage> tourImages) {
		this.tourImages = tourImages;
	}
	

}
