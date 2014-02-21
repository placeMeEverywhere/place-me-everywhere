package com.placeMe.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.placeMe.jdbc.SpringContext;

public class SpringContextServlet extends HttpServlet {

	private static final long serialVersionUID = 1913449756682794960L;

	@Override
	public void init() throws ServletException {
		// inizializzazione spring context
		SpringContext.INSTANCE.init();
	}
	
	
}
