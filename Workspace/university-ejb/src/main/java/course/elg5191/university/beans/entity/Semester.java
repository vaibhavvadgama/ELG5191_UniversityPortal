package course.elg5191.university.beans.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import course.elg5191.university.University.Term;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Entity
public class Semester 
{
	//Declaration
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int semesterId;
	private Term term;
	private int year;
	private Date beginDate;
	private Date endDate;
	private Date dropDeadlineDate;

	//Constructor
	public Semester()
	{

	}

	//Public Accessors
	public int getSemesterId()
	{
		return this.semesterId;
	}

	/**
	 * 
	 * @param semesterId
	 * @return 
	 */
	public void setSemesterId(int semesterId)
	{
		this.semesterId = semesterId;
	}

	public Term getTerm()
	{
		return this.term;
	}

	/**
	 * 
	 * @param term
	 */
	public void setTerm(Term term)
	{
		this.term = term;
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

	public Date getBeginDate()
	{
		return this.beginDate;
	}

	/**
	 * 
	 * @param beginDate
	 */
	public void setBeginDate(Date beginDate)
	{
		this.beginDate = beginDate;
	}

	public Date getEndDate()
	{
		return this.endDate;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public Date getDropDeadlineDate()
	{
		return this.dropDeadlineDate;
	}

	/**
	 * 
	 * @param dropDeadlineDate
	 */
	public void setDropDeadlineDate(Date dropDeadlineDate)
	{
		this.dropDeadlineDate = dropDeadlineDate;
	}
	
	@Override
	public String toString()
	{
		return term + " - " + year;
	}
	

}