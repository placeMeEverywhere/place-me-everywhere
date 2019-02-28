package com.placeMe.jdbc.entity;

import java.io.Serializable;

public class Category implements Serializable {
	
	private static final long serialVersionUID = 7013071787608716379L;
	private int id;	
	private String categoryName;
	private byte[] categoryImage;
	private String categoryLabel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public byte[] getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(byte[] categoryImage) {
		this.categoryImage = categoryImage;
	}
	public String getCategoryLabel() {
		return categoryLabel;
	}
	public void setCategoryLabel(String categoryLabel) {
		this.categoryLabel = categoryLabel;
	}
	
}
