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
 * @created 16-Nov-2012 11:34:03 AM
 */

@Entity
public class StudentApplication 
{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recordId;
	private int year;
	private String program;
	private String department;
	private int studentId;
	private StudentApplicationStatus status;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public StudentApplication()
	{

	}

	//Public Accessors
	public int getRecordId()
	{
		return this.recordId;
	}

	/**
	 * 
	 * @param recordId
	 */
	public void setRecordId(int recordId)
	{
		this.recordId = recordId;
	}

	public int getYear()
	{
		return this.year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year)
	{
		this.year = year;
	}

	public String getProgram()
	{
		return this.program;
	}

	/**
	 * 
	 * @param program
	 */
	public void setProgram(String program)
	{
		this.program = program;
	}

	public String getDepartment()
	{
		return this.department;
	}

	/**
	 * 
	 * @param department
	 */
	public void setDepartment(String department)
	{
		this.department = department;
	}

	public int getStudentId()
	{
		return this.studentId;
	}

	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}

	public StudentApplicationStatus getStatus()
	{
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(StudentApplicationStatus status)
	{
		this.status = status;
	}

	public boolean getIsActive()
	{
		return this.isActive;
	}

	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public Date getCreatedDate()
	{
		return this.createdDate;
	}

	/**
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getModifiedDate()
	{
		return this.modifiedDate;
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