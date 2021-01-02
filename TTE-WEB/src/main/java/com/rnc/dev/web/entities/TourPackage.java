package com.rnc.dev.web.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TourPackage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	private String name;
	
	@Lob
	private String image;
	
	@OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL)
	private List<TourImage> images;
	
	@ManyToOne
	private State stateFrom;
	
	@ManyToOne
	private State stateTo;
	
	@ManyToOne
	private Hotel hotel;
	
	@ManyToOne
	private Vehicle vehicle;
	
	private long days;
	
	private String timeFrom;
	
	private LocalDate dateFrom;
	
	private String timeTo;
	
	private LocalDate dateTo;
	
	private long quantity;
	
	private double price;
	
	@Lob
	private String description;
	
	private String arriveTime;
	
	@Lob
	private String terminal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<TourImage> getImages() {
		return images;
	}

	public void setImages(List<TourImage> images) {
		this.images = images;
	}

	public State getStateFrom() {
		return stateFrom;
	}

	public void setStateFrom(State stateFrom) {
		this.stateFrom = stateFrom;
	}

	public State getStateTo() {
		return stateTo;
	}

	public void setStateTo(State stateTo) {
		this.stateTo = stateTo;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public long getDays() {
		return days;
	}

	public void setDays(long days) {
		this.days = days;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
}