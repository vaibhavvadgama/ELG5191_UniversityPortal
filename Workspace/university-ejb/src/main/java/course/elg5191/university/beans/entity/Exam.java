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
	private int taughtCourseId;
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
		return this.examId;
	}

	public int getTaughtCourseId()
	{
		return this.taughtCourseId;
	}

	public ExamType getExamType()
	{
		return this.examType;
	}

	public ConductType getConductType()
	{
		return this.conductType;
	}

	public int getCreatedByUserId()
	{
		return this.createdByUserId;
	}

	public Date getPublishedDateTime()
	{
		return this.publishedDateTime;
	}

	public Date getDueDateTime()
	{
		return this.dueDateTime;
	}

	public int getTotalMarks()
	{
		return this.totalMarks;
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
	 * @param examId
	 */
	public void setExamId(int examId)
	{
		this.examId = examId;
	}

	/**
	 * 
	 * @param taughtCourseId
	 */
	public void setTaughtCourseId(int taughtCourseId)
	{
		this.taughtCourseId = taughtCourseId;
	}

	/**
	 * 
	 * @param examType
	 */
	public void setExamType(ExamType examType)
	{
		this.examType = examType;
	}

	/**
	 * 
	 * @param conductType
	 */
	public void setConductType(ConductType conductType)
	{
		this.conductType = conductType;
	}

	/**
	 * 
	 * @param createdByUserId
	 */
	public void setCreatedByUserId(int createdByUserId)
	{
		this.createdByUserId = createdByUserId;
	}

	/**
	 * 
	 * @param publishedDateTime
	 */
	public void setPublishedDateTime(Date publishedDateTime)
	{
		this.publishedDateTime = publishedDateTime;
	}

	/**
	 * 
	 * @param dueDateTime
	 */
	public void setDueDateTime(Date dueDateTime)
	{
		this.dueDateTime = dueDateTime;
	}

	/**
	 * 
	 * @param totalMarks
	 */
	public void setTotalMarks(int totalMarks)
	{
		this.totalMarks = totalMarks;
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