package course.elg5191.university.ui;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.session.CourseSession;
/**
 * @author Alexandros
 * @version 1.0
 * @created 17-Nov-2012 7:13:44 AM
 */
@ManagedBean(name = "registrationBean")
@SessionScoped
public class RegistrationBean 
{
	//Declarations
	@EJB
	private CourseSession courseSess;
	
	
	//Constructor
	public RegistrationBean()
	{

	}

}