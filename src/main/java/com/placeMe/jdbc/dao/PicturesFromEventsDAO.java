package com.placeMe.jdbc.dao;

import com.placeMe.web.ajax.Picture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.placeMe.jdbc.util.QueryBuilder.GET_PICTURES_FROM_EVENTS;

public class PicturesFromEventsDAO extends PlaceMeDAO {

	public List<Picture> retrievePicturesFromEvents() {
		List<Picture> pictures = new ArrayList<Picture>();
		List<Map<String, Object>> res = jdbcTemplate.queryForList(GET_PICTURES_FROM_EVENTS);
		for(Map<String, Object> single : res){
			Picture p = new Picture();
			p.setTitle((String)single.get("picture_name"));
			p.setSrc((byte[]) single.get("picture"));
			p.setLocation(new String((byte[]) single.get("picture")));
			pictures.add(p);
		}
		return pictures;
	}
}
