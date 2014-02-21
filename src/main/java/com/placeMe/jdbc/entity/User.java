package com.placeMe.jdbc.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 2037676325101581281L;
	private String id;
	private String email;
	private String password;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
