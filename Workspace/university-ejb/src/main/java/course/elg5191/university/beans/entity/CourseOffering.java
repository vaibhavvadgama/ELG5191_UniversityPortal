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
public class CourseOffering 
{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int offeringId;
	private int offeredByProfId;
	private int createdByAdminId;
	private int semester;
	private Date time;
	private String location;
	private int maxStudents;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public CourseOffering()
	{

	}

	
	//Public Accessors
	public int getOfferingId()
	{
		return 0;
	}

	public int getOfferedByProfId()
	{
		return 0;
	}

	public int getCreatedByAdminId()
	{
		return 0;
	}

	public int getSemester()
	{
		return 0;
	}

	public Date getTime()
	{
		return null;
	}

	public String getLocation()
	{
		return "";
	}

	public int getMaxStudents()
	{
		return 0;
	}

	public boolean getIsActive(){
		return false;
	}

	public Date getCreatedDate(){
		return null;
	}

	public Date getModifiedDate(){
		return null;
	}

	/**
	 * 
	 * @param offeringId
	 */
	public void setOfferingId(int offeringId){

	}

	/**
	 * 
	 * @param offeredByProfId
	 */
	public void setOfferedByProfId(int offeredByProfId){

	}

	/**
	 * 
	 * @param createdByAdminId
	 */
	public void setCreatedByAdminId(int createdByAdminId){

	}

	/**
	 * 
	 * @param semester
	 */
	public void setSemester(int semester){

	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(Date time){

	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location){

	}

	/**
	 * 
	 * @param maxStudents
	 */
	public void setMaxStudents(int maxStudents){

	}

	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(boolean isActive){

	}

	/**
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate){

	}

	/**
	 * 
	 * @param modifiedDate
	 */
	public void setModifiedDate(Date modifiedDate){

	}

}