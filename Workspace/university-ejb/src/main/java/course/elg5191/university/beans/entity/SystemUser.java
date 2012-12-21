package course.elg5191.university.beans.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import course.elg5191.university.University.UserRole;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Entity
public class SystemUser 
{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date birthDate;
	private String name;
	private UserRole role;

	//Tim
	private String emailid;
	private String address;

	public void setAddress( String address)
	{
		this.address = address;
	}
	public void setEmailid( String emailid)
	{
	 	this.emailid = emailid;
	}
	public String getEmailid()
	{
		return this.emailid;
	}
	public String getAddress()
	{
	 	return this.address;
	}
	//End


	//Public Accessors
	public Date getBirthDate()
	{
		return this.birthDate;
	}

	public int getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	/**
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}