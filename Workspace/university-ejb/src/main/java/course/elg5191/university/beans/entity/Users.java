package course.elg5191.university.beans.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import course.elg5191.university.University.UserRole;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@SuppressWarnings("serial")
@Entity
public class Users implements Serializable

{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private Date birthDate;
	
	@Size(min = 2, message = "Name too short")
	private String firstName;

	@Size(min = 2, message = "Name too short")
	private String lastName;

	private String role;

	//Tim
	private String emailid;
	private String address;
	
	private Boolean isActive;
	private String password;
	
	private Date createdDate;
	private Date modifiedDate;
	private String salt;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
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

	public Date getBirthDate()
	{
		return this.birthDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName()
	{
		return this.firstName + " " + this.lastName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}