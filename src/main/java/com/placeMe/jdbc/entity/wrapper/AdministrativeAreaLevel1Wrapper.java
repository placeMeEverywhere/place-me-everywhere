package com.placeMe.jdbc.entity.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.placeMe.jdbc.entity.AdministrativeAreaLevel1;

public class AdministrativeAreaLevel1Wrapper implements RowMapper<AdministrativeAreaLevel1> {

	@Override
	public AdministrativeAreaLevel1 mapRow(ResultSet rs, int arg1) throws SQLException {
		AdministrativeAreaLevel1 area = new AdministrativeAreaLevel1();
		area.setId(rs.getString("id"));
		area.setAreaName(rs.getString("area_name"));
		return area;
	}

}
