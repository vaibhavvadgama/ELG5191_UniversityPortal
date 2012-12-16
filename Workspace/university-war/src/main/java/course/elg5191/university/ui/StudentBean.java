package course.elg5191.university.ui;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.entity.SystemUser;
import course.elg5191.university.beans.session.SystemUserSession;
import course.elg5191.university.view.CourseInformationData;
import course.elg5191.university.view.CourseInformationDataModel;

@ManagedBean(name = "studentBean")
@SessionScoped
public class StudentBean {
	@EJB
	private SystemUserSession userSess;
	private SystemUser user;
	private CourseInformationDataModel courseInformationDataModel;
	
	//Public Methods
	public void setUserId(String userId)
	{
		//Step 1: Get the instance of the user
		System.out.println("setting the system user with id " + userId);
		
		this.user = userSess.getUserById(Integer.parseInt(userId));
		
		//Step 2: build the drop course data model
		System.out.println("setting the system user with id " + userId);
		courseInformationDataModel = buildCourseInformationDataModel();
	}
	
	public String getUserId()
	{
		System.out.println("getting the system user id");
		if (user == null)
			return "";
		else
			return Integer.toString(this.user.getId());
	}
	
	public CourseInformationDataModel getDropCourseDataModel()
	{
		System.out.println("getDropCourseDataModel");
		
		if (courseInformationDataModel == null)
		{
			
		}
		return courseInformationDataModel;
	}
	
	private CourseInformationDataModel buildCourseInformationDataModel()
	{
		//Step 1: Verify we have a user set
		if (user == null) 
			return null;
		
	//Step 2: Obtain all StudentCourseRegistration entries which have state ma
		
		
		return null;
	}
}