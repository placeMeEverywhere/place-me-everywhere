package com.placeMe.web.business;

import java.util.HashMap;
import java.util.Map;

import com.placeMe.web.business.user.UserAPI;
import com.placeMe.web.business.user.UserAPIImpl;

public class PlaceMeAPILocator {

	private static Map<String, Object> apis = new HashMap<String, Object>();
	
	static {
		apis.put("UserAPI", new UserAPIImpl());
		
	}
	
	public static UserAPI getUserAPI(){
		return (UserAPI)apis.get("UserAPI");
	}
}
