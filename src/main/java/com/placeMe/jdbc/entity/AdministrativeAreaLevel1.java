package com.placeMe.jdbc.entity;

import java.io.Serializable;

public class AdministrativeAreaLevel1 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3983519356755455953L;
	private String id;
	private String areaName;
	private Country country;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
