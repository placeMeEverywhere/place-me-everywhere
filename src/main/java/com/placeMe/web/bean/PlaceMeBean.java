package com.placeMe.web.bean;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public abstract class PlaceMeBean {
	
	protected String getMessage(String property) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
		return bundle.getString(property);
	}
}
