package com.placeMe.jdbc.entity;

import java.io.Serializable;

public class Profile implements Serializable {

	private static final long serialVersionUID = -179816298716655265L;
	private String id;
	private String firstName;
	private String lastName;
	private String avatarPath;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAvatarPath() {
		return avatarPath;
	}
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
}
