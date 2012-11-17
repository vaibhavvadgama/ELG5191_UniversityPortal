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
public class User 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date birthDate;
	private String name;

	public User()
	{

	}

	public Date getBirthDate(){
		return null;
	}

	public int getId(){
		return 0;
	}

	public String getName(){
		return "";
	}

	/**
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(Date birthDate){

	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id){

	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){

	}

}