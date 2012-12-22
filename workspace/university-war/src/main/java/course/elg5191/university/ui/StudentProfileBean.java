package course.elg5191.university.ui;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import course.elg5191.university.beans.entity.StudentApplication;
import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.UsersSession;
import course.elg5191.university.beans.session.StudentApplicationSession;
import course.elg5191.university.view.StudentProfileData;

//Tim

@ManagedBean(name = "studentProfileBean")
@SessionScoped
public class StudentProfileBean {
	
	@EJB
	private UsersSession userSess;
	@EJB
	private StudentApplicationSession studentApplication;
	
	//Somehow it's not good for using the Class SystemUser here directly
	private Users user;
	
	//private int userID = 0; //!!! 0 for INVALID_USER_ID, it should be macro defined somewhere !!!
	//Student Profile Data
    private StudentProfileData studentProfileData;
	
    //The below two vars should be moved to Class StudentProfileData
	private String emailidinput;
	private String addressinput;
	//
	
	public String getEmailidinput()
	{
		System.out.println("StudentProfile Bean:: getEmailidinput:" + this.emailidinput + '!');
		return this.emailidinput;
	}
	public void setEmailidinput( String e)
	{
		System.out.println("StudentProfile Bean:: setEmailidinput:" + e);

		if( e.length() != 0 && user != null)
		{
			this.studentProfileData.setEmailid(e);
			this.emailidinput = "";
			//Change database effectively here
			userSess.changeEmailidOfSystemUser(Integer.parseInt(this.getUserId()), e);
		}
		this.emailidinput = "";
	}

	public String getAddressinput()
	{
		return this.addressinput;
	}
	public void setAddressinput( String a)
	{
		if( a.length() != 0 && user != null)
		{
			this.studentProfileData.setAddress(a);
			//
			//Change database effectively
			userSess.changeAddressOfSystemUser(Integer.parseInt(this.getUserId()), a);
			//
		}
		this.addressinput = "";
	}

	//Public Methods
	public void setUserId(String userId)
	{
	
		int uid = 0;
		
		try { uid = Integer.parseInt(userId);
		} catch(NumberFormatException e) {uid = 0;} 
		finally{
		
		//Step 1: Get the instance of the user
		System.out.println("StudentProfile Bean:: setUserId !!!in" + userId);
		
		this.user = userSess.getUserById(uid);
		
		System.out.println("StudentProfile Bean:: setUserId !!!out" + userId);
	
		//Step 2: build the student profile data
		studentProfileData = buildStudentProfileData();
		this.emailidinput = "";
		}
	}
	
	public String getUserId()
	{
		System.out.println("StudentProfile Bean:: Getting the system user id ");
		if (user == null)
			return "";
		else
		{
			System.out.println("StudentProfile Bean:: Getting the system user id " + this.user.getUserId());
			return Integer.toString(this.user.getUserId());
			
		}
	}
	private StudentProfileData buildStudentProfileData()
	{
		System.out.println("StudentProfile Bean:: buildStudentProfileData");
		
		//Coding as like what Jamieson does. 
		//Step 1: Verify we have a user set
		if (user == null)
		{
			System.out.println("Error: No user has been set!");
			return new StudentProfileData();
		}
		
		StudentProfileData spd = new StudentProfileData();
		spd.setStudentid(Integer.toString(user.getUserId()));
		spd.setName(user.getName());
		spd.setAddress(user.getAddress());
		spd.setEmailid(user.getEmailid());
		
		spd.setDepartment(null);
		spd.setYear(null);
		spd.setProgram(null);
		
		
		/////////////
		//Step 2: Obtain all StudentCourseRegistration entries by studentId
				List<StudentApplication> allSA = studentApplication.getStudentApplicationByStudentId(user.getUserId());
				if(allSA == null)
				{
					System.out.println("no current student application");
					return null;
				}
				else
				{
					System.out.println(allSA.size() + " current student application(s) available");	
				}
				
				//Step 3: 
				for(StudentApplication currentSA : allSA)
				{
					spd.setDepartment(currentSA.getDepartment());
					spd.setProgram(currentSA.getProgram());
					spd.setYear(Integer.toString(currentSA.getYear()));
				}
		/////////////
				
		return spd;
	}

public StudentProfileData getStudentProfileData()
{
	if (this.studentProfileData == null)
		return new StudentProfileData();
	
	return this.studentProfileData;
}
}