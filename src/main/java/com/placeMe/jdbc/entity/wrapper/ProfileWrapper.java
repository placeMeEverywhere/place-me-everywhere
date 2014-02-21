package com.placeMe.jdbc.entity.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.placeMe.jdbc.entity.Profile;

public class ProfileWrapper implements RowMapper<Profile> {

	@Override
	public Profile mapRow(ResultSet rs, int arg1) throws SQLException {
		
		return null;
	}

}
