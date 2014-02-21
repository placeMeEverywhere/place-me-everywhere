package com.placeMe.jdbc.entity;

import java.io.Serializable;

public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1167239208961622738L;
	private String id;
	private String countryName;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
