package course.elg5191.university.ui;

import static course.elg5191.university.util.Messages.addFlashMessage;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.UsersSession;

@RequestScoped
@ManagedBean(name = "deleteUser")
public class DeleteUser {
	
	private Users user;
	
	@EJB
	private UsersSession userSI;
	
	public String delete() {
		userSI.deleteUser(user);
		addFlashMessage("User: " + user.getFirstName() + " " + user.getLastName() + " (id:" + user.getUserId() + ") deleted");
		return "retrieve_users.xhtml?faces-redirect=true";
	}
	
	public String cancel() {
		return "retrieve_users.xhtml?faces-redirect=true";
	}
	
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
}
