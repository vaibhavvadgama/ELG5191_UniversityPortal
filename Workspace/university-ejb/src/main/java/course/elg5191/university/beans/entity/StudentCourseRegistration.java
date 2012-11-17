package course.elg5191.university.beans.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import course.elg5191.university.University;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */

@Entity
public class StudentCourseRegistration {

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
		return 0;
	}

	/**
	 * 
	 * @param registrationId
	 */
	public void setRegistrationId(int registrationId)
	{

	}

	public int getOfferedCourseId()
	{
		return 0;
	}

	/**
	 * 
	 * @param offeredCourseId
	 */
	public void setOfferedCourseId(int offeredCourseId)
	{

	}

	public int getStudentId()
	{
		return 0;
	}

	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(int studentId)
	{

	}

	public int getApprovedUserId()
	{
		return 0;
	}

	/**
	 * 
	 * @param approvedUserId
	 */
	public void setApprovedUserId(int approvedUserId)
	{

	}

	public boolean getIsExempted()
	{
		return false;
	}

	/**
	 * 
	 * @param isExempted
	 */
	public void setIsExempted(boolean isExempted)
	{

	}

	public String getExemptionDetails()
	{
		return "";
	}

	/**
	 * 
	 * @param exemptionDetails
	 */
	public void setExemptionDetails(String exemptionDetails)
	{

	}

	public int getObtainedMarks()
	{
		return 0;
	}

	/**
	 * 
	 * @param obtainedMarks
	 */
	public void setObtainedMarks(int obtainedMarks)
	{

	}

	public String getObtainedGrade(){
		return "";
	}

	/**
	 * 
	 * @param obtainedGrade
	 */
	public void setObtainedGrade(String obtainedGrade)
	{

	}

	public boolean getIsActive()
	{
		return false;
	}

	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(boolean isActive)
	{

	}

	public Date getCreatedDate()
	{
		return null;
	}

	/**
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate)
	{

	}

	public Date getModifiedDate()
	{
		return null;
	}

	/**
	 * 
	 * @param modifiedDate
	 */
	public void setModifiedDate(Date modifiedDate)
	{

	}

}