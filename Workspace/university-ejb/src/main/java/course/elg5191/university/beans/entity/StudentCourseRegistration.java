package course.elg5191.university.beans.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */

@Entity
public class StudentCourseRegistration 
{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int registrationId;
	private int offeredCourseId;
	private int studentId;
	private int approvedUserId;
	private boolean isExempted;
	private String exemptionDetails;
	private int obtainedMarks;
	private String obtainedGrade;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public StudentCourseRegistration()
	{

	}

	//Public Accessors
	public int getRegistrationId()
	{
		return this.registrationId;
	}

	/**
	 * 
	 * @param registrationId
	 */
	public void setRegistrationId(int registrationId)
	{
		this.registrationId = registrationId;
	}

	public int getOfferedCourseId()
	{
		return this.offeredCourseId;
	}

	/**
	 * 
	 * @param offeredCourseId
	 */
	public void setOfferedCourseId(int offeredCourseId)
	{
		this.offeredCourseId = offeredCourseId;
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

	public int getApprovedUserId()
	{
		return this.approvedUserId;
	}

	/**
	 * 
	 * @param approvedUserId
	 */
	public void setApprovedUserId(int approvedUserId)
	{
		this.approvedUserId = approvedUserId;
	}

	public boolean getIsExempted()
	{
		return this.isExempted;
	}

	/**
	 * 
	 * @param isExempted
	 */
	public void setIsExempted(boolean isExempted)
	{
		this.isExempted = isExempted;
	}

	public String getExemptionDetails()
	{
		return this.exemptionDetails;
	}

	/**
	 * 
	 * @param exemptionDetails
	 */
	public void setExemptionDetails(String exemptionDetails)
	{
		this.exemptionDetails = exemptionDetails;
	}

	public int getObtainedMarks()
	{
		return this.obtainedMarks;
	}

	/**
	 * 
	 * @param obtainedMarks
	 */
	public void setObtainedMarks(int obtainedMarks)
	{
		this.obtainedMarks = obtainedMarks;
	}

	public String getObtainedGrade(){
		return this.obtainedGrade;
	}

	/**
	 * 
	 * @param obtainedGrade
	 */
	public void setObtainedGrade(String obtainedGrade)
	{
		this.obtainedGrade = obtainedGrade;
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