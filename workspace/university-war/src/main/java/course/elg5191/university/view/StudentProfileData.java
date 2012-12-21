package course.elg5191.university.view;

//
// By Timothy on 1st, December, 2012
//
public class StudentProfileData
{
	//Declarations
	
	private String studentid;
	private String name;
	
	private String year;
	private String program;
	private String department;
	
	private String emailid;
	private String address;
	
	//Getters and Setters
	public void setStudentid(String sid)
	{
		this.studentid = sid;
	}
	
	public String getStudentid()
	{
		return this.studentid;
	}
	
	public void setYear(String year)
	{
		this.year = year;
	}
	
	public String getYear()
	{
		return this.year;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void setProgram(String p)
	{
		this.program = p;
	}
	
	public String getProgram()
	{
		return this.program;
	}
	public void setDepartment(String d)
	{
		this.department = d;
	}
	
	public String getDepartment()
	{
		return this.department;
	}
	public void setEmailid(String e)
	{
		this.emailid = e;
	}
	
	public String getEmailid()
	{
		return this.emailid;
	}
	public void setAddress(String a)
	{
		this.address = a;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
}
