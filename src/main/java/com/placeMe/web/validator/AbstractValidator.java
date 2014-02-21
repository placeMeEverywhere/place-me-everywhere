package com.placeMe.web.validator;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public abstract class AbstractValidator {
	
	protected String getMessage(String property) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
		return bundle.getString(property);
	}
}
