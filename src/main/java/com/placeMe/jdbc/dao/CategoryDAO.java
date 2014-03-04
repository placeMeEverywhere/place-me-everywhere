package com.placeMe.jdbc.dao;

import static com.placeMe.jdbc.util.QueryBuilder.GET_ALL_CATEGORIES;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.placeMe.jdbc.entity.Category;

public class CategoryDAO extends PlaceMeDAO {
	
	public List<Category> retrieveCategories() {
		List<Category> categories = new ArrayList<Category>();
		List<Map<String, Object>> res = jdbcTemplate.queryForList(GET_ALL_CATEGORIES);
		for(Map<String, Object> single : res){
			Category c = new Category();
			c.setId((Integer)single.get("id"));
			c.setCategoryName((String)single.get("category_name"));
			c.setCategoryImage((String)single.get("category_image"));
			c.setCategoryLabel((String)single.get("category_label"));
			categories.add(c);
		}
		Collections.shuffle(categories);
		return categories;
	}
}
