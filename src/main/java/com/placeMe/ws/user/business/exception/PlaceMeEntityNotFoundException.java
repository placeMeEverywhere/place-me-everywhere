package com.placeMe.ws.user.business.exception;

public class PlaceMeEntityNotFoundException extends Exception {

	private static final long serialVersionUID = 6233496411918452968L;

	@Override
	public String getMessage() {
		return "La classe indicata come Entity non è configurata come tale.";
	}
	
	
}
