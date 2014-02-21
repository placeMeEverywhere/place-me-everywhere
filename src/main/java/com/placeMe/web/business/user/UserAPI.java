package com.placeMe.web.business.user;

import com.placeMe.jdbc.entity.User;
import com.placeMe.jdbc.exception.UserNotFoundException;

public interface UserAPI {
	
	boolean checkUser(String email);
	
	User find(String username, String password) throws UserNotFoundException;
}
