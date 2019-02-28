package com.placeMe.jdbc.dao;

import com.placeMe.jdbc.entity.Category;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.placeMe.jdbc.util.QueryBuilder.GET_ALL_CATEGORIES;

public class CategoryDAO extends PlaceMeDAO {

	public List<Category> retrieveCategories() throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		List<Map<String, Object>> res = jdbcTemplate.queryForList(GET_ALL_CATEGORIES);
		for(Map<String, Object> single : res){
			Category c = new Category();
			c.setId((Integer)single.get("id"));
			c.setCategoryName((String)single.get("category_name"));
			c.setCategoryImage((byte[]) single.get("category_image"));
			c.setCategoryLabel((String)single.get("category_label"));
			categories.add(c);
		}
		Collections.shuffle(categories);
		return categories;
	}
}
