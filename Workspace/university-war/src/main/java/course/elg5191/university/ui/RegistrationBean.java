package course.elg5191.university.ui;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.entity.Semester;
import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.*;
/**
 * @author jmccausl
 * @version 1.0
 * @created 17-Nov-2012 7:13:44 AM
 */
@ManagedBean(name = "registrationBean")
@SessionScoped
public class RegistrationBean 
{
	//Declarations
	@EJB
	private UsersSession userSess;
	@EJB
	private CoursePrerequisiteSession coursePrerequisiteSess;
	@EJB
	private SemesterSession semesterSess;
	@EJB
	private StudentCourseRegistrationSession studentCourseRegistrationSess;
	@EJB
	private CoursesSession courseSess;
	private Users currentUser;
	private Semester currentSemester;
	
	//Constructor
	public RegistrationBean()
	{

	}

}