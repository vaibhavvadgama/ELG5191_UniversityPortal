package course.elg5191.university.view;

//
// By Timothy on 1st, December, 2012
//
public class StudentHistoryData
{
	//Declarations
	private int registrationId;
	private int offeringId;
	
	private String courseCode;
	private String term;
	private String year;
	private int obtainedMarks;
	private String obtainedGrade;
	private String others;
	
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
	
	public void setObtainedMarks(int obtainedMarks)
	{
		this.obtainedMarks = obtainedMarks;
	}
	
	public int getObtainedMarks()
	{
		return this.obtainedMarks;
	}
	
	
	public void setObtainedGrade(String obtainedGrade)
	{
		this.obtainedGrade = obtainedGrade;
	}
	
	public String getObtainedGrade()
	{
		return this.obtainedGrade;
	}
	
	public void setOthers(String others)
	{
		this.others = others;
	}
	
	public String getOthers()
	{
		return this.others;
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
	
	}

