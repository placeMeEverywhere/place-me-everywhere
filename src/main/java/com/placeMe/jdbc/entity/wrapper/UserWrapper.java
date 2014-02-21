package com.placeMe.jdbc.entity.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.placeMe.jdbc.entity.User;

public class UserWrapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User aUser = new User();
		aUser.setId(rs.getString("id"));
		aUser.setEmail(rs.getString("email"));
		aUser.setPassword(rs.getString("password"));
		return aUser;
	}

}
