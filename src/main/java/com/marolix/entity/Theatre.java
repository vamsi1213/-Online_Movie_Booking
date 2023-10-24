package com.marolix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theatre_Id")
	private Integer theatreId;
	private String theatreName;
	private int theatreCapacity;
	private String city;
	
	
	public Theatre() {
		super();
	}
	public Theatre(Integer theatreId, String theatreName, int theatreCapacity, String city) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCapacity = theatreCapacity;
		this.city = city;
	}
	
	
	public Integer getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public int getTheatreCapacity() {
		return theatreCapacity;
	}
	public void setTheatreCapacity(int theatreCapacity) {
		this.theatreCapacity = theatreCapacity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCapacity="
				+ theatreCapacity + ", city=" + city + "]";
	}
	
	
}
