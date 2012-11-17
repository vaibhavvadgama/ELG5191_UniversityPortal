package course.elg5191.university.ui;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.session.UserSession;
import course.elg5191.university.beans.entity.User;

/**
 * @author Alexandros
 * @version 1.0
 * @created 17-Nov-2012 7:13:44 AM
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean 
{
	//Declarations
	@EJB
	private UserSession userSess;
	private User user;
	
	//Constructor
	public UserBean()
	{

	}

	//Public Methods
}