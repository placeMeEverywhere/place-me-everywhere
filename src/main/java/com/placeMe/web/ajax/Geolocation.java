package com.placeMe.web.ajax;

import com.placeMe.jdbc.entity.AdministrativeAreaLevel1;
import com.placeMe.jdbc.entity.Country;
import com.placeMe.jdbc.entity.Location;

public class Geolocation {
	
	private Country country;
	private AdministrativeAreaLevel1 area;
	private Location location;
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public AdministrativeAreaLevel1 getArea() {
		return area;
	}
	public void setArea(AdministrativeAreaLevel1 area) {
		this.area = area;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
}
