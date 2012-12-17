package course.elg5191.university.view;

public class CourseInformationData
{
	//Declarations
	private int registrationId;
	private int offeringId;
	private String courseCode;
	private String term;
	private String year;
	private String dropDeadlineDate;
	
	//Getters and Setters
	public void setRegistrationId(int registrationId)
	{
		this.registrationId = registrationId;
	}
	
	public int getRegistrationId()
	{
		return this.registrationId;
	}
	
	public void setOfferingId(int offeringId)
	{
		this.offeringId = offeringId;
	}
	
	public int getOfferingId()
	{
		return this.offeringId;
	}
	
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	
	public String getCourseCode()
	{
		return this.courseCode;
	}
	
	public void setTerm(String term)
	{
		this.term = term;
	}
	
	public String getTerm()
	{
		return this.term;
	}

	public String getYear()
	{
		return this.year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}
	
	public String getDropDeadlineDate()
	{
		return this.dropDeadlineDate;
	}

	public void setDropDeadlineDate(String dropDeadlineDate)
	{
		this.dropDeadlineDate = dropDeadlineDate;
	}
}

