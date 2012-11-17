package course.elg5191.university.beans.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import course.elg5191.university.University;
import course.elg5191.university.University.ExamSubmissionStatus;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Entity
public class ExamSubmission 
{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int submissionId;
	private int examId;
	private int studentId;
	private Date submitDateTime;
	private String comments;
	private ExamSubmissionStatus status;
	private int obtainedMarks;
	private String obtainedGrade;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	//Constructor
	public ExamSubmission()
	{

	}

	//Public Accessors
	public int getSubmissionId()
	{
		return 0;
	}

	/**
	 * 
	 * @param submissionId
	 */
	public void setSubmissionId(int submissionId)
	{

	}

	public int getExamId(){
		return 0;
	}

	/**
	 * 
	 * @param examId
	 */
	public void setExamId(int examId)
	{

	}

	public int getStudentId(){
		return 0;
	}

	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(int studentId)
	{

	}

	public Date getSubmitDateTime()
	{
		return null;
	}

	/**
	 * 
	 * @param submitDateTime
	 */
	public void setSubmitDateTime(Date submitDateTime)
	{

	}

	public String getComments()
	{
		return "";
	}

	/**
	 * 
	 * @param comments
	 */
	public void setComments(String comments)
	{

	}

	public ExamSubmissionStatus getStatus()
	{
		return null;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(ExamSubmissionStatus status)
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

	public String getObtainedGrade()
	{
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