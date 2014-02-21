package com.placeMe.ws.user.business.exception;

public class PlaceMeFieldNotFoundException extends Exception{

	private static final long serialVersionUID = -2031262219363679908L;
	
	public String getMessage(){
		return "La classe non possiede il medoto invocato.";
	}
}
