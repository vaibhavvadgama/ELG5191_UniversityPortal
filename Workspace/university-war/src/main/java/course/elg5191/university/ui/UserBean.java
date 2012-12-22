package course.elg5191.university.ui;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.session.UsersSession;
import course.elg5191.university.beans.entity.Users;

/**
 * @author jmccausl
 * @version 1.0
 * @created 17-Nov-2012 7:13:44 AM
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean 
{
	//Declarations
	@EJB
	private UsersSession userSess;
	private Users user;
		
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
			return Integer.toString(this.user.getUserId());
	}
	
	public List<Users> getProfessors()
	{
		return userSess.getAllProfs();
	}
}