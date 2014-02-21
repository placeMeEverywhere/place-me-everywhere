package com.placeMe.jdbc.entity;

import java.io.Serializable;

public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7247361007354516317L;
	private String id;
	private String locationName;
	private AdministrativeAreaLevel1 area;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public AdministrativeAreaLevel1 getArea() {
		return area;
	}
	public void setArea(AdministrativeAreaLevel1 area) {
		this.area = area;
	}
}
