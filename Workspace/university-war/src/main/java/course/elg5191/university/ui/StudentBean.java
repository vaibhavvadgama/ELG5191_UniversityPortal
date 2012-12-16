package course.elg5191.university.ui;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.entity.SystemUser;
import course.elg5191.university.beans.session.SystemUserSession;

@ManagedBean(name = "studentBean")
@SessionScoped
public class StudentBean {
	@EJB
	private SystemUserSession userSess;
	private SystemUser user;
	
	//Public Methods
	public void setUserId(String userId)
	{
		System.out.println("setting the system user with id " + userId);
		
		this.user = userSess.getUserById(Integer.parseInt(userId));
	}
	
	public String getUserId()
	{
		System.out.println("getting the system user id");
		if (user == null)
			return "";
		else
			return Integer.toString(this.user.getId());
	}
	
}