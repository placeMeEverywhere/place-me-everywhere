package com.placeMe.ws.user.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class PlaceMeWSUpdateUser {
	
	@WebMethod
	public String sayHelloUpdate(){
		return "Hello Update";
	}
}
