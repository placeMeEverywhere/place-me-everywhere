package com.placeMe.web.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.placeMe.jdbc.SpringContext;
import com.placeMe.jdbc.dao.CategoryDAO;
import com.placeMe.jdbc.entity.Category;
 
@ManagedBean(name="category")
@SessionScoped
public class CategoryBean implements Serializable {

    private static final long serialVersionUID = 2756934361134603857L;
    private List<Category> categories;

	public List<Category> getCategories() throws SQLException {
		if(null==categories){
			categories = new ArrayList<Category>();
			CategoryDAO cDAO = SpringContext.INSTANCE.getBean("categoryDAO", CategoryDAO.class);
			List<Category> appo = cDAO.retrieveCategories();
			categories.addAll(appo);
		}
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
    
    
}