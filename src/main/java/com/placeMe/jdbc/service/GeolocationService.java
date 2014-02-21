package com.placeMe.jdbc.service;

import org.springframework.dao.DataAccessException;

import com.placeMe.jdbc.dao.GeolocationDAO;
import com.placeMe.jdbc.entity.Location;

public class GeolocationService extends PlaceMeService {
	
	private Location location;
	private GeolocationDAO geoDAO;
	
	@Override
	public void serve() throws DataAccessException {
		geoDAO.insertLocation(location);
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setGeoDAO(GeolocationDAO geoDAO) {
		this.geoDAO = geoDAO;
	}

}
