package com.placeMe.jdbc.entity.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.placeMe.jdbc.entity.Country;

public class CountryWrapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int arg1) throws SQLException {
		Country country = new Country();
		country.setId(rs.getString("id"));
		country.setCountryName(rs.getString("country_name"));
		return country;
	}

}
