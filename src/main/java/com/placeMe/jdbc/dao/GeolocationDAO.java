package com.placeMe.jdbc.dao;

import java.util.HashMap;
import java.util.Map;

import com.placeMe.jdbc.entity.AdministrativeAreaLevel1;
import com.placeMe.jdbc.entity.Country;
import com.placeMe.jdbc.entity.Location;
import com.placeMe.jdbc.entity.wrapper.AdministrativeAreaLevel1Wrapper;
import com.placeMe.jdbc.entity.wrapper.CountryWrapper;

import static com.placeMe.jdbc.util.QueryBuilder.COUNTRY_INSERT;
import static com.placeMe.jdbc.util.QueryBuilder.COUNTRY_SELECT;
import static com.placeMe.jdbc.util.QueryBuilder.AREA_INSERT;
import static com.placeMe.jdbc.util.QueryBuilder.AREA_SELECT;
import static com.placeMe.jdbc.util.QueryBuilder.LOCATION_INSERT;
import static com.placeMe.jdbc.util.QueryBuilder.COUNTRY_CHECK;
import static com.placeMe.jdbc.util.QueryBuilder.AREA_CHECK;
import static com.placeMe.jdbc.util.QueryBuilder.LOCATION_CHECK;

public class GeolocationDAO extends PlaceMeDAO {

	/**
	 * Inserisce una nuova Citta (location).
	 * 
	 * @param country la citta che si vuole inserire.
	 */
	public void insertLocation(Location location) {
		if(!existCountry(location.getArea().getCountry()))
			insertCountry(location.getArea().getCountry());
		else
			System.out.println("Country already exists");
		location.getArea().setCountry(retrieveCountry(location.getArea().getCountry().getCountryName()));
		if(!existAdministrativeArea(location.getArea()))
			insertAdministrativeArea(location.getArea());
		else
			System.out.println("AdministrativeArea already exists");
		AdministrativeAreaLevel1 area = retrieveAdministrativeArea(location.getArea().getAreaName());
		area.setCountry(location.getArea().getCountry());
		location.setArea(area);
		if(!existLocation(location)){
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", location.getId());
			params.put("locationName", location.getLocationName());
			params.put("idArea", location.getArea().getId());
			namedParameterJdbcTemplate.update(LOCATION_INSERT, params);
		}else
			System.out.println("Location already exists");
	}

	/**
	 * Inserisce una nuova Nazione (country).
	 * 
	 * @param country la nazione che si vuole inserire.
	 */
	private void insertCountry(Country country) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", country.getId());
		params.put("countryName", country.getCountryName());
		namedParameterJdbcTemplate.update(COUNTRY_INSERT, params);
	}

	/**
	 * Inserisce una nuova AdministrativeAreaLevel1 (regione).
	 * 
	 * @param country la nazione che si vuole inserire.
	 */
	private void insertAdministrativeArea(AdministrativeAreaLevel1 area) {
		if(!existAdministrativeArea(area)){
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", area.getId());
			params.put("areaName", area.getAreaName());
			params.put("idCountry", area.getCountry().getId());
			namedParameterJdbcTemplate.update(AREA_INSERT, params);
		}else{
			area = retrieveAdministrativeArea(area.getAreaName());
			System.out.println("AdministrativeAreaLevel1 already exists");
		}
	}
	
	private Country retrieveCountry(String countryName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("countryName", countryName);
		return namedParameterJdbcTemplate.queryForObject(COUNTRY_SELECT, params, new CountryWrapper());
	}

	private AdministrativeAreaLevel1 retrieveAdministrativeArea(String areaName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("areaName", areaName);
		return namedParameterJdbcTemplate.queryForObject(AREA_SELECT, params, new AdministrativeAreaLevel1Wrapper());
	}

	
	private boolean existCountry(Country country){
		Map<String, String> params = new HashMap<String, String>();
		params.put("countryName", country.getCountryName());
		int count = namedParameterJdbcTemplate.queryForInt(COUNTRY_CHECK, params);
		if(count==1)
			return true;
		else
			return false;
	}

	private boolean existAdministrativeArea(AdministrativeAreaLevel1 area){
		Map<String, String> params = new HashMap<String, String>();
		params.put("areaName", area.getAreaName());
		int count = namedParameterJdbcTemplate.queryForInt(AREA_CHECK, params);
		if(count==1)
			return true;
		else
			return false;
	}
	
	private boolean existLocation(Location location){
		Map<String, String> params = new HashMap<String, String>();
		params.put("locationName", location.getLocationName());
		int count = namedParameterJdbcTemplate.queryForInt(LOCATION_CHECK, params);
		if(count==1)
			return true;
		else
			return false;
	}
}
