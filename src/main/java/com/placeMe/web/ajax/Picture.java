package com.placeMe.web.ajax;

import java.io.Serializable;

public class Picture implements Serializable{
	
	private static final long serialVersionUID = -6167239278484011311L;
	private byte[] src;
	private String title;
	private String location;
	
	public byte[] getSrc() {
		return src;
	}
	public void setSrc(byte[] src) {
		this.src = src;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }
}
