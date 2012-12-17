package course.elg5191.university.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

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
		List<StudentCourseRegistration> currentCourses = studentCourseRegistrationSess.getStudentCourseRegistrationsByStatus(StudentCourseRegistrationStatus.Current);
		if(currentCourses == null)
		{
			System.out.println("no current courses");
			return null;
		}
		else
		{
			System.out.println(currentCourses.size() + " current course(s) available");	
		}
		
		//Step 3: Populate the CourseInformationDataModel object for the DataTable
		List<CourseInformationData> courseInformation = new ArrayList<CourseInformationData>();
		for(StudentCourseRegistration currentCourse : currentCourses)
		{
			CourseInformationData courseInfo = new CourseInformationData();
			
			//Step 3.2: Set the Offering ID
			courseInfo.setOfferingId(currentCourse.getOfferingId());
			
			//Step 3.3: Get the course offering and semester
			CourseOffering courseOffering = courseOfferingSess.getCourseOfferingByOfferingId(currentCourse.getOfferingId());
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