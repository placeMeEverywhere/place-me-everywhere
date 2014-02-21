package com.placeMe.web.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.placeMe.jdbc.SpringContext;
import com.placeMe.jdbc.dao.UserDAO;
import com.placeMe.jdbc.entity.Location;
import com.placeMe.jdbc.entity.Profile;
import com.placeMe.jdbc.entity.User;
import static com.placeMe.util.PlaceMeConstants.LOCATION_PARAM;

@ManagedBean(name="insertUser")
@SessionScoped
public class InsertUserBean extends AbstractWizardBean implements Serializable {
	
	private static final long serialVersionUID = -8780087225925960280L;
	private User user;
	private Profile profile;
	private UploadedFile avatar;
	private Location currentLocation;
	
	@PostConstruct
	public void init(){
		super.init();
		user = new User();
		profile = new Profile();
	}
	
	public String checkUser() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		currentLocation = (Location)sessionMap.get(LOCATION_PARAM);		
		UserDAO userDAO = SpringContext.INSTANCE.getBean("userDAO", UserDAO.class);
		if(userDAO.checkUser(user.getEmail())) {
			FacesMessage msg = new FacesMessage(getMessage("msg.error.validator.emailAlreadyExists"), getMessage("msg.error.validator.emailAlreadyExists"));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
		return goToProfile();
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public UploadedFile getAvatar() {
		return avatar;
	}
	public void setAvatar(UploadedFile avatar) {
		this.avatar = avatar;
	}
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
}
