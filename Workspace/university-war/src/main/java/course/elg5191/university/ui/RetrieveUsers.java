package course.elg5191.university.ui;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.UsersSession;

@SuppressWarnings("serial")
@RequestScoped
@ManagedBean(name = "retrieveUsers")
public class RetrieveUsers implements Serializable{

	private List<Users> users;
	
	@EJB
	private UsersSession userSI;
	
	@PostConstruct
	public void init() {
		users = userSI.getAllUsers();
	}

	public List<Users> getUsers() {
		return users;
	}
}
