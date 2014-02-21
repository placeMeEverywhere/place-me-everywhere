package com.placeMe.web.servlet;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.placeMe.PlaceMeContext;

public class PlaceMeContextServlet extends HttpServlet {

	private static final long serialVersionUID = -6713077215221273401L;
	
	@Override
	public void init() throws ServletException {
		// inizializzazione spring context
		try {
			PlaceMeContext.INSTANCE.init();
			checkProxy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void checkProxy(){
		if(null!=System.getProperty("http.proxyHost") || null!=System.getProperty("https.proxyHost")){
			Authenticator.setDefault(new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					if (getRequestorType() == RequestorType.PROXY) {
						String prot = getRequestingProtocol().toLowerCase();
						String host = System.getProperty(prot + ".proxyHost", "");
						String port = System.getProperty(prot + ".proxyPort", "");
						String user = System.getProperty(prot + ".proxyUser", "");
						String password = System.getProperty(prot + ".proxyPassword", "");
				 
						if (getRequestingHost().toLowerCase().equals(host.toLowerCase())) {
							if (Integer.parseInt(port) == getRequestingPort()) {								
								return new PasswordAuthentication(user, password.toCharArray());
							}
						}
					}
					return null;
				}
	
			});	
		}
	}
}
