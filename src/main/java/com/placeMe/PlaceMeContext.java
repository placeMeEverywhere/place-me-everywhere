package com.placeMe;

import java.io.IOException;
import java.util.Properties;

public class PlaceMeContext {
	
	public static PlaceMeContext INSTANCE = new PlaceMeContext();
	private Properties context = new Properties();
	
	private PlaceMeContext(){}
	
	public void init() throws IOException{
		context.load(this.getClass().getClassLoader().getResourceAsStream("placeMe-config.properties"));
	}
	
	public String get(String key){
		return context.getProperty(key);
	}
}
