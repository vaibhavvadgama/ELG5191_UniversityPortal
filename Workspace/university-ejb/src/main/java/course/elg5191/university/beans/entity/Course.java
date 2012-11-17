package course.elg5191.university.beans.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Entity
public class Course {

	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String courseName;
	private String departmentCode;
	private String courseNumber;
	private String courseLevel;
	private String description;
	private int createdBy;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public Course()
	{

	}

	//Public Accessors
	public int getCourseId()
	{
		return this.courseId;
	}
	
	public void setCourseId(int courseId)
	{
		this.courseId = courseId;
	}

	public String getCourseName()
	{
		return this.courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public String getDepartmentCode()
	{
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode)
	{
		this.departmentCode = departmentCode;
	}
	
	public String getCourseNumber()
	{
		return this.courseNumber;
	}
	
	public void setCourseNumber(String courseNumber)
	{
		this.courseNumber = courseNumber;
	}

	public String getCourseLevel()
	{
		return this.courseLevel;
	}
	
	public void setCourseLevel(String courseLevel)
	{
		this.courseLevel = courseLevel;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public int getCreatedBy()
	{
		return this.createdBy;
	}
	
	public void setCreatedBy(int createdBy)
	{
		this.createdBy = createdBy;
	}

	public boolean getIsActive()
	{
		return this.isActive;
	}
	
	public void setIsActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public Date getCreatedDate()
	{
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getModifiedDate()
	{
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}
}