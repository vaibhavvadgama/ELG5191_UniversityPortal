package course.elg5191.university.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import course.elg5191.university.University.StudentApplicationStatus;
import course.elg5191.university.University.StudentCourseRegistrationStatus;
import course.elg5191.university.beans.entity.CourseOffering;
import course.elg5191.university.beans.entity.Semester;
import course.elg5191.university.beans.entity.StudentCourseRegistration;
import course.elg5191.university.beans.entity.SystemUser;
import course.elg5191.university.beans.session.CourseOfferingSession;
import course.elg5191.university.beans.session.SemesterSession;
import course.elg5191.university.beans.session.StudentCourseRegistrationSession;
import course.elg5191.university.beans.session.SystemUserSession;
import course.elg5191.university.view.CourseInformationData;
import course.elg5191.university.view.CourseInformationDataModel;

@ManagedBean(name = "studentBean")
@SessionScoped
public class StudentBean {
	@EJB
	private SystemUserSession userSess;
	@EJB
	private StudentCourseRegistrationSession studentCourseRegistrationSess;
	@EJB
	private CourseOfferingSession courseOfferingSess;
	@EJB
	private SemesterSession semesterSess;
	
	private CourseInformationData[] selectedCourses;
	private SystemUser user;
	private CourseInformationDataModel courseInformationDataModel;
	
	//Public Methods
	public void setUserId(String userId)
	{
		//Step 1: Get the instance of the user
		System.out.println("StudenBean:: setUserId " + userId);
		
		this.user = userSess.getUserById(Integer.parseInt(userId));
		
		//Step 2: build the drop course data model
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
		System.out.println("StudenBean:: getDropCourseDataModel");
		
		if (this.courseInformationDataModel == null)
			return new CourseInformationDataModel();
		
		return this.courseInformationDataModel;
	}
	
	public void setSelectedCourses(CourseInformationData[] selectedCourses)
	{
		System.out.println("StudentBean:: setSelectedCourses");
		this.selectedCourses = selectedCourses;
	}
	
	public CourseInformationData[] getSelectedCourses()
	{
		System.out.println("StudentBean:: getSelectedCourses");
		return this.selectedCourses;
	}

	public void DropSelectedCourses(ActionEvent event)
	{
		System.out.println("StudentBean:: DropSelectedCourses");

		//Step 1: Make sure selected courses is not null
		if (selectedCourses != null)
		{
			//Step 2: Check for any selected courses to drop
			if (selectedCourses.length > 0)
			{
				System.out.println("StudentBean:: There are courses selected to drop");
				
				//Step 3: Change the status of each course registration to Dropped
				for(CourseInformationData courseInformation : this.selectedCourses)
				{
					//Step 4: Set the course registration to Dropped
					studentCourseRegistrationSess.changeStatusOfCourseRegistration(courseInformation.getRegistrationId(), StudentCourseRegistrationStatus.Dropped);
				}
				this.courseInformationDataModel = buildCourseInformationDataModel();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Courses Dropped"));
			}
		}
	}
	
	private CourseInformationDataModel buildCourseInformationDataModel()
	{
		System.out.println("StudenBean:: buildCourseInformationDataModel");
		
		//Step 1: Verify we have a user set
		if (user == null)
		{
			System.out.println("Error: No user has been set!");
			return new CourseInformationDataModel();
		}
		
		//Step 2: Obtain all StudentCourseRegistration entries which have the status 'Current'
		List<StudentCourseRegistration> allCoursesRegistrations = studentCourseRegistrationSess.getStudentCourseRegistrationsByStatus(StudentCourseRegistrationStatus.Current);
		if(allCoursesRegistrations == null)
		{
			System.out.println("no current courses");
			return null;
		}
		else
		{
			System.out.println(allCoursesRegistrations.size() + " current course(s) available");	
		}
		
		//Step 3: Populate the CourseInformationDataModel object for the DataTable
		List<CourseInformationData> courseInformation = new ArrayList<CourseInformationData>();
		for(StudentCourseRegistration currentCourseRegistration : allCoursesRegistrations)
		{
			CourseInformationData courseInfo = new CourseInformationData();
			
			//Step 3.1: Set the Course Registration Id
			courseInfo.setRegistrationId(currentCourseRegistration.getRegistrationId());
			
			//Step 3.2: Set the Offering ID
			courseInfo.setOfferingId(currentCourseRegistration.getOfferingId());
			
			//Step 3.3: Get the course offering and semester
			CourseOffering courseOffering = courseOfferingSess.getCourseOfferingByOfferingId(currentCourseRegistration.getOfferingId());
			Semester semester = semesterSess.getSemesterBySemesterId(courseOffering.getSemesterId());
			//Step 3.4: Set the Course Code 
			String courseCode = courseOffering.getCourse().getDepartmentCode();
			courseCode += " " + courseOffering.getCourse().getCourseNumber();
			courseInfo.setCourseCode(courseCode);
			
			//Step 3.5: Set the Drop Date Deadline
			courseInfo.setDropDeadlineDate(semester.getDropDeadlineDate().toString());
			
			//Step 3.6: Set the Term
			courseInfo.setTerm(semester.getTerm().name());
			
			//Step 3.7: Set the Year
			courseInfo.setYear(Integer.toString(semester.getYear()));
			
			courseInformation.add(courseInfo);
		}
		
		return new CourseInformationDataModel(courseInformation);
	}

}