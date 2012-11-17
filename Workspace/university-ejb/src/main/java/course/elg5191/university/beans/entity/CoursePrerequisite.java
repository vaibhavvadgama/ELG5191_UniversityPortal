package course.elg5191.university.beans.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import course.elg5191.university.University.*;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Entity
public class CoursePrerequisite 
{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prereqId;
	private int courseId;
	private PrereqType prereqType;
	private String prereqValue;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public CoursePrerequisite()
	{

	}

	//Public Accessors
	public int getPrereqId()
	{
		return this.prereqId;
	}

	public int getCourseId()
	{
		return this.courseId;
	}

	public PrereqType getPrereqType()
	{	
		return this.prereqType;
	}

	public String getPrereqValue()
	{
		return this.prereqValue;
	}

	public boolean getIsActive()
	{
		return this.isActive;
	}

	public Date getCreatedDate()
	{
		return this.createdDate;
	}

	public Date getModifiedDate()
	{
		return this.modifiedDate;
	}

	/**
	 * 
	 * @param prereqId
	 */
	public void setPrereqId(int prereqId)
	{
		this.prereqId = prereqId;
	}

	/**
	 * 
	 * @param courseId
	 */
	public void setCourseId(int courseId)
	{
		this.courseId = courseId;
	}

	/**
	 * 
	 * @param prereqType
	 */
	public void setPrereqType(PrereqType prereqType)
	{
		this.prereqType = prereqType;
	}

	/**
	 * 
	 * @param prereqValue
	 */
	public void setPrereqValue(String prereqValue)
	{
		this.prereqValue = prereqValue;
	}

	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	/**
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	/**
	 * 
	 * @param modifiedDate
	 */
	public void setModifiedDate(Date modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}

}