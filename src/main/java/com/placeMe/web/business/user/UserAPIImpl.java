package com.placeMe.web.business.user;

import com.placeMe.jdbc.SpringContext;
import com.placeMe.jdbc.dao.UserDAO;
import com.placeMe.jdbc.entity.User;
import com.placeMe.jdbc.exception.UserNotFoundException;

public class UserAPIImpl implements UserAPI {

	public UserDAO uDAO;
	
	public UserAPIImpl(){
		uDAO = SpringContext.INSTANCE.getBean("userDAO", UserDAO.class);
	}
	
	@Override
	public boolean checkUser(String email) {
		return uDAO.checkUser(email);
	}

	@Override
	public User find(String username, String password) throws UserNotFoundException{
		throw new UserNotFoundException();
	}

}
