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
		return this.submissionId;
	}

	/**
	 * 
	 * @param submissionId
	 */
	public void setSubmissionId(int submissionId)
	{
		this.submissionId = submissionId;
	}

	public int getExamId()
	{
		return this.examId;
	}

	/**
	 * 
	 * @param examId
	 */
	public void setExamId(int examId)
	{
		this.examId = examId;
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

	public Date getSubmitDateTime()
	{
		return this.submitDateTime;
	}

	/**
	 * 
	 * @param submitDateTime
	 */
	public void setSubmitDateTime(Date submitDateTime)
	{
		this.submitDateTime = submitDateTime;
	}

	public String getComments()
	{
		return this.comments;
	}

	/**
	 * 
	 * @param comments
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public ExamSubmissionStatus getStatus()
	{
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(ExamSubmissionStatus status)
	{
		this.status = status;
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

	public String getObtainedGrade()
	{
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