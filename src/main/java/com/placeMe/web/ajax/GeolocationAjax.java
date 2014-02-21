package com.placeMe.web.ajax;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.placeMe.jdbc.SpringContext;
import com.placeMe.jdbc.entity.AdministrativeAreaLevel1;
import com.placeMe.jdbc.entity.Country;
import com.placeMe.jdbc.entity.Location;
import com.placeMe.jdbc.service.GeolocationService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import static com.placeMe.util.PlaceMeConstants.LOCATION_PARAM;

public class GeolocationAjax {
	
	public void retrieveGeolocation(double latitude, double longitude, String language) throws MalformedURLException, IOException{
		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();
		String city = null;
		String area = null;
		String country = null;
		if(null==session.getAttribute(LOCATION_PARAM)){
			String latlong=String.valueOf(latitude)+","+String.valueOf(longitude);				
			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng="+latlong+"&sensor=false&language=it");
			InputStream in = url.openStream();
			String resp = IOUtils.toString(in);
	    	JSONObject json = (JSONObject) JSONSerializer.toJSON(resp);
	    	JSONArray results = json.getJSONArray("results");
	   		JSONObject result = (JSONObject)results.get(0);
	   		JSONArray addressComponents = result.getJSONArray("address_components");
	   		for(Object addressComponent_obj:addressComponents){
	   			JSONObject addressComponent = (JSONObject)addressComponent_obj;
	   			JSONArray types = addressComponent.getJSONArray("types");
	   			for(Object type_obj:types){
	   				String type = (String)type_obj;
	   				if("locality".equals(type)){
	   					city = addressComponent.getString("long_name");
	   				}else if("country".equals(type))
	   					country = addressComponent.getString("long_name");
	   				else if("administrative_area_level_1".equals(type))
	   					area = addressComponent.getString("long_name");
	   			}
	   		}
	   		Location locationBean = retrieveLocation(country, area, city);
	   		GeolocationService geoService = SpringContext.INSTANCE.getBean("geolocationService", GeolocationService.class);
	   		geoService.setLocation(locationBean);
	   		geoService.serve();
	   		session.setAttribute(LOCATION_PARAM, locationBean);
		}
	}
	
	private Location retrieveLocation(String _country, String _area, String _location) {
		Country country = new Country();
		country.setId(UUID.randomUUID().toString());
		country.setCountryName(_country);
		AdministrativeAreaLevel1 area = new AdministrativeAreaLevel1();
		area.setId(UUID.randomUUID().toString());
		area.setAreaName(_area);
		area.setCountry(country);
		Location location = new Location();
		location.setId(UUID.randomUUID().toString());
		location.setLocationName(_location);
		location.setArea(area);
		return location;
	}
}
