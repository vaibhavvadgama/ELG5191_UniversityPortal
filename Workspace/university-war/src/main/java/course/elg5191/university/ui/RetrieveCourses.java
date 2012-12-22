package course.elg5191.university.ui;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import course.elg5191.university.beans.entity.Courses;
import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.CoursesSession;

@SuppressWarnings("serial")
@RequestScoped
@ManagedBean(name = "retrieveCourses")
public class RetrieveCourses implements Serializable{
	private List<Courses> courses;
	
	@EJB
	private CoursesSession courseSI;
	
	private Users user;
	private UserSession session;
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public RetrieveCourses() {
		session = new UserSession();
		user = session.getLoggedUser();
	}
	
	@PostConstruct
	public void init() {
		courses = courseSI.getAllCourses();
	}

	public List<Courses> getCourses() {
		return courses;
	}
}
