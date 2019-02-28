package com.placeMe.jdbc.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class PlaceMeDAO {

	protected JdbcTemplate jdbcTemplate;
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	protected Logger logger = Logger.getLogger(this.getClass());
	
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	protected JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
		return namedParameterJdbcTemplate;
	}
}
