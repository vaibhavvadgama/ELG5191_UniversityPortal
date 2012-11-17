package course.elg5191.university.beans.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import course.elg5191.university.University;
import course.elg5191.university.University.PrereqType;

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
	private PrereqType prereqtype;
	private String prereqvalue;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public CoursePrerequisite()
	{

	}

	//Public Accessors
	public int getPrereqId(){
		return 0;
	}

	public int getCourseId(){
		return 0;
	}

	public PrereqType getPrereqType()
	{	
		return null;
	}

	public void getPrereqValue(){

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
	 * @param prereqId
	 */
	public void setPrereqId(int prereqId){

	}

	/**
	 * 
	 * @param courseId
	 */
	public void setCourseId(int courseId){

	}

	/**
	 * 
	 * @param prereqType
	 */
	public void setPrereqType(PrereqType prereqType)
	{

	}

	/**
	 * 
	 * @param prereqValue
	 */
	public void setPrereqValue(String prereqValue){

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