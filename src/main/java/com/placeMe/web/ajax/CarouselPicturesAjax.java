package com.placeMe.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.placeMe.jdbc.SpringContext;
import com.placeMe.jdbc.dao.PicturesFromEventsDAO;

public class CarouselPicturesAjax {
	
	public String getPicturesFromEvents() {
		try {
			WebContext ctx = WebContextFactory.get();
			HttpServletResponse response = ctx.getHttpServletResponse();
			PicturesFromEventsDAO pDAO = SpringContext.INSTANCE.getBean("picturesFromEventsDAO", PicturesFromEventsDAO.class);
			List<Picture> pictures = pDAO.retrievePicturesFromEvents();
//			CarouselPicture cp = new CarouselPicture();
//			cp.setItems(pictures);
			PrintWriter out = response.getWriter();
			JSONArray json_array = (JSONArray) JSONSerializer.toJSON(pictures);
			JSONObject json = json_array.toJSONObject(json_array);
			StringBuilder sb = new StringBuilder();
			sb.append(json.toString());
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		
	}
}
