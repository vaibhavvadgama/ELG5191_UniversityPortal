package course.elg5191.university.ui;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.session.CourseSession;

/**
 * @author jmccausl
 * @version 1.0
 * @created 17-Nov-2012 7:13:43 AM
 */
@ManagedBean(name = "courseBean")
@SessionScoped
public class CourseBean 
{
	//Declarations
	@EJB
	private CourseSession courseSess;
	
	//Constructor
	public CourseBean()
	{

	}
	
	//Public Methods
}