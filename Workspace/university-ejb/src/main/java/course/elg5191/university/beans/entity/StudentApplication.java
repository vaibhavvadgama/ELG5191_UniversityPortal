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
public class StudentApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recordId;
	private int year;
	private String program;
	private String department;
	private int studentId;
	private enum status;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	public StudentApplication(){

	}

	public void finalize() throws Throwable {

	}

	public int getRecordId(){
		return 0;
	}

	/**
	 * 
	 * @param recordId
	 */
	public void setRecordId(int recordId){

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

	public String getProgram(){
		return "";
	}

	/**
	 * 
	 * @param program
	 */
	public void setProgram(String program){

	}

	public String getDepartment(){
		return "";
	}

	/**
	 * 
	 * @param department
	 */
	public void setDepartment(String department){

	}

	public int getStudentId(){
		return 0;
	}

	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(int studentId){

	}

	public enum getStatus(){
		return null;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(enum status){

	}

	public boolean getIsActive(){
		return false;
	}

	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(boolean isActive){

	}

	public Date getCreatedDate(){
		return null;
	}

	/**
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate){

	}

	public Date getModifiedDate(){
		return null;
	}

	/**
	 * 
	 * @param modifiedDate
	 */
	public void setModifiedDate(Date modifiedDate){

	}

}