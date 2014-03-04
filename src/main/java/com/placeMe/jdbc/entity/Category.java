package com.placeMe.jdbc.entity;

public class Category {
	
	private int id;	
	private String categoryName;
	private String categoryImage;
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
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	public String getCategoryLabel() {
		return categoryLabel;
	}
	public void setCategoryLabel(String categoryLabel) {
		this.categoryLabel = categoryLabel;
	}
	
}
