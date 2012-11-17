package course.elg5191.university.beans.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import course.elg5191.university.University.ConductType;
import course.elg5191.university.University.ExamType;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Entity
public class Exam 
{

	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examId;
	private int toughtCourseId;
	private ExamType examType;
	private ConductType conductType;
	private int createdByUserId;
	private Date publishedDateTime;
	private Date dueDateTime;
	private int totalMarks;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public Exam()
	{

	}

	//Public Accessors
	public int getExamId()
	{
		return 0;
	}

	public int getTaughtCourseId(){
		return 0;
	}

	public ExamType getExamType(){
		return null;
	}

	public ConductType getConductType(){
		return null;
	}

	public int getCreatedByUserId(){
		return 0;
	}

	public Date getPublishedDateTime(){
		return null;
	}

	public Date getDueDateTime(){
		return null;
	}

	public int getTotalMarks(){
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
	 * @param examId
	 */
	public void setExamId(int examId){

	}

	/**
	 * 
	 * @param taughtCourseId
	 */
	public void setTaughtCourseId(int taughtCourseId){

	}

	/**
	 * 
	 * @param examType
	 */
	public void setExamType(ExamType examType)
	{

	}

	/**
	 * 
	 * @param conductType
	 */
	public void setConductType(ConductType conductType)
	{

	}

	/**
	 * 
	 * @param createdByUserId
	 */
	public void setCreatedByUserId(int createdByUserId){

	}

	/**
	 * 
	 * @param publishedDateTime
	 */
	public void setPublishedDateTime(Date publishedDateTime){

	}

	/**
	 * 
	 * @param dueDateTime
	 */
	public void setDueDateTime(Date dueDateTime){

	}

	/**
	 * 
	 * @param totalMarks
	 */
	public void setTotalMarks(int totalMarks){

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