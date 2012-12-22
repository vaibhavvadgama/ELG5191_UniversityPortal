package course.elg5191.university.ui;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import course.elg5191.university.beans.entity.CourseOffering;
import course.elg5191.university.beans.entity.Semester;
import course.elg5191.university.beans.entity.StudentCourseRegistration;
import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.CourseOfferingSession;
import course.elg5191.university.beans.session.SemesterSession;
import course.elg5191.university.beans.session.StudentCourseRegistrationSession;
import course.elg5191.university.beans.session.UsersSession;
import course.elg5191.university.view.StudentHistoryData;
import course.elg5191.university.view.StudentHistoryDataModel;

//Tim
//Coding as what Jamieson does

@ManagedBean(name = "studentHistoryBean")
@SessionScoped
public class StudentHistoryBean {
	@EJB
	private UsersSession userSess;
	@EJB
	private StudentCourseRegistrationSession studentCourseRegistrationSess;
	@EJB
	private CourseOfferingSession courseOfferingSess;
	@EJB
	private SemesterSession semesterSess;
	
	//not good for using SystemUser directly, change later
	private Users user;
	private StudentHistoryDataModel studentHistoryDataModel;
	
	//Public Methods
	public void setUserId(String userId)
	{
		//Step 1: Get the instance of the user
		System.out.println("StudentHistory Bean:: setUserId " + userId);
		
		this.user = userSess.getUserById(Integer.parseInt(userId));
		
		//Step 2: build the student history data
		studentHistoryDataModel = buildStudentHistoryDataModel();
	}
	
	public String getUserId()
	{
		System.out.println("StudentHistory Bean:: Getting the system user id");
		if (user == null)
			return "";
		else
			return Integer.toString(this.user.getUserId());
	}
	
	public StudentHistoryDataModel getStudentHistoryDataModel()
	{
		System.out.println("StudentHistory Bean:: getStudentHistoryDataModel");
		
		if (this.studentHistoryDataModel == null)
			return new StudentHistoryDataModel();
		
		return this.studentHistoryDataModel;
	}
	

	private StudentHistoryDataModel buildStudentHistoryDataModel()
	{
		System.out.println("StudentHistory Bean:: buildCourseInformationDataModel");
		
		//Step 1: Verify we have a user set
		if (user == null)
		{
			System.out.println("Error: No user has been set!");
			return new StudentHistoryDataModel();
		}
		
		//Step 2: Obtain all StudentCourseRegistration entries by studentId
		List<StudentCourseRegistration> allCoursesRegistrations = studentCourseRegistrationSess.getStudentCourseRegistrationsByStudentId(user.getUserId());
		if(allCoursesRegistrations == null)
		{
			System.out.println("no current courses registered");
			return null;
		}
		else
		{
			System.out.println(allCoursesRegistrations.size() + " current course(s) available");	
		}
		
		//Step 3: Populate the CourseInformationDataModel object for the DataTable
		List<StudentHistoryData> studentHistory = new ArrayList<StudentHistoryData>();
		for(StudentCourseRegistration currentCourseRegistration : allCoursesRegistrations)
		{
			StudentHistoryData studentH = new StudentHistoryData();
			
			//Step 3.1: Set the Course Registration Id
			studentH.setRegistrationId(currentCourseRegistration.getRegistrationId());
			
			//Step 3.2: Set the Offering ID
			studentH.setOfferingId(currentCourseRegistration.getOfferingId());
			
			//Step 3.3: Get the course offering and semester
			CourseOffering courseOffering = courseOfferingSess.getCourseOfferingByOfferingId(currentCourseRegistration.getOfferingId());
			Semester semester = semesterSess.getSemesterBySemesterId(courseOffering.getSemesterId());
			
			//Step 3.4: Set the Course Code 
			String courseCode = courseOffering.getCourse().getDepartmentCode();
			courseCode += " " + courseOffering.getCourse().getCourseNumber();
			studentH.setCourseCode(courseCode);
			
			//Set obtainedMarks;
			studentH.setObtainedMarks(currentCourseRegistration.getObtainedMarks());
			
			//Set obtainedGrade;
			studentH.setObtainedGrade(currentCourseRegistration.getObtainedGrade());
			
			//Set others = NULL;
			studentH.setOthers(null);
			
			//Step 3.6: Set the Term
			studentH.setTerm(semester.getTerm().name());
			
			//Step 3.7: Set the Year
			studentH.setYear(Integer.toString(semester.getYear()));
			
			studentHistory.add(studentH);
		}
		
		return new StudentHistoryDataModel(studentHistory);
	}

}