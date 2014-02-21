package com.placeMe.jdbc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import static com.placeMe.jdbc.util.QueryBuilder.USER_CHECK;

import com.placeMe.jdbc.entity.wrapper.UserWrapper;

/**
 * DAO per la gestione degli utenti.
 * 
 * @author Graziano Aliberti PlaceME Everywhere
 *
 * @date Mar 9, 2013
 */

public class UserDAO extends PlaceMeDAO {
	
	public boolean checkUser(String email) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", email);
		try{
			namedParameterJdbcTemplate.queryForObject(USER_CHECK, params, new UserWrapper());
		}catch(EmptyResultDataAccessException e){
			return false;
		}
		return true;	
	}
}
