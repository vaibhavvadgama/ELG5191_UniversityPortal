package course.elg5191.university.ui;

import static course.elg5191.university.util.Messages.addFlashMessage;
import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.UsersSession;

@SuppressWarnings("serial")
@RequestScoped
@ManagedBean(name = "editUser")
public class EditUser implements Serializable {
	private Users user;
	
	private UserSession session;

	public EditUser() {
		
		session = new UserSession();
		user = new Users();
		
//		if(user == null) {
//			user = new Users();
//		}
		
		/*
		 * 
		 * Fetch passed username and role
		 * compare it with database
		 * if username and role matches, then the user is verified and the login is secure
		 * otherwise, redirect the user to login
		 * 
		 */
	}

	@EJB
	private UsersSession userSI;

	public void preRenderView() {
		if (user == null || user.equals("") || !(user instanceof Users)) {
			user = new Users();
		}
	}

	public String saveUser() {
		if (user.getUserId() != 0) {
			user.setModifiedDate(new Date());
			userSI.updateUser(user);
		} else {
			user.setCreatedDate(new Date());
			userSI.createUser(user);
		}
		addFlashMessage("User: " + user.getFirstName() + " "
				+ user.getLastName() + " (id: " + user.getUserId()
				+ ") was saved successfully.");
		return "retrieve_users.xhtml?faces-redirect=true";
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
	}
	
	public Users getLoggedUser() {
		FacesContext context = FacesContext.getCurrentInstance();  
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
		HttpSession httpSession = request.getSession(false);  
		Users reqdObj = (Users) httpSession.getAttribute("loggedUser");
		
		try {
			System.out.println("From Admin Home: Logged User : " + reqdObj.getUserId() + " " + reqdObj.getEmailid());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return reqdObj;
	}
	
}
