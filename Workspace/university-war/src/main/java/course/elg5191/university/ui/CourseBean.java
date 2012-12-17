package course.elg5191.university.ui;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.entity.Semester;
import course.elg5191.university.beans.entity.SystemUser;
import course.elg5191.university.beans.session.*;

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

	@EJB
	private SemesterSession semSess;



	//Constructor
	public CourseBean()
	{
	} 
	
	//Public Methods
	public List<String> getDepartments()
	{
		return courseSess.getAllDepartments();
	}
	
	public List<Semester> getSemesters()
	{
		return semSess.getAllSemesters();
	}

	
	
}