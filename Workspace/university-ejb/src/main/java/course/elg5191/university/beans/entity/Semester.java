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
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int semesterId;
	private int term;
	private int year;
	private Date beginDate;
	private Date endDate;
	private Date dropDeadlineDate;

	public Semester(){

	}

	public void finalize() throws Throwable {

	}

	public int getSemesterId(){
		return 0;
	}

	/**
	 * 
	 * @param semesterId
	 * @return 
	 */
	public void setSemesterId(int semesterId){

	}

	public int getTerm(){
		return 0;
	}

	/**
	 * 
	 * @param term
	 */
	public void setTerm(int term){

	}

	public int getYear(){
		return 0;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year){

	}

	public Date getBeginDate(){
		return null;
	}

	/**
	 * 
	 * @param beginDate
	 */
	public void setBeginDate(Date beginDate){

	}

	public Date getEndDate(){
		return null;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate){

	}

	public Date getDropDeadlineDate(){
		return null;
	}

	/**
	 * 
	 * @param dropDeadlineDate
	 */
	public void setDropDeadlineDate(Date dropDeadlineDate){

	}

}