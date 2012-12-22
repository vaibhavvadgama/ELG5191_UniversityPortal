package course.elg5191.university.ui;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import course.elg5191.university.beans.entity.Users;

@SuppressWarnings("serial")
@ManagedBean(name = "sessionBean")
@RequestScoped
public class UserSession implements Serializable {

	public void verifySession() {
		try {
			if (!isUserLoggedIn()) {
				FacesContext.getCurrentInstance().getExternalContext()
						.dispatch("/securelogin.xhtml?faces-redirect=true");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isUserLoggedIn() {
		boolean isUserLogged = false;
		Users loggedUser = getLoggedUser();
		if (loggedUser != null) {
			isUserLogged = true;
		}
		return isUserLogged;
	}

	public Users getLoggedUser() {
		Users tempLoggedUser = null;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			HttpSession httpSession = request.getSession(false);
			tempLoggedUser = (Users) httpSession.getAttribute("loggedUser");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tempLoggedUser;
	}

	public void initSession(Users loggedUser) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		httpSession.setAttribute("loggedUser", loggedUser);
	}

	public void printLoggedUserDetails() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		Users reqdObj = (Users) httpSession.getAttribute("loggedUser");

		try {
			System.out.println("Logged User : " + reqdObj.getUserId() + " "
					+ reqdObj.getEmailid());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void destroySession() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			HttpSession httpSession = request.getSession(false);
			httpSession.invalidate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" No Session information initialized");
		}
	}

	public String logout() {
		// addFlashMessage("Hi + " + getLoggedUser().getFirstName() +
		// ", you have been logged out successfully.");
		destroySession();
		return "securelogin.xhtml?faces-redirect=true";
	}

}
