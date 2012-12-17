	package course.elg5191.university.beans.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Entity
public class CourseOffering 
{
	//Declarations
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int offeringId;
	private int offeredByProfId;
	private int createdByAdminId;
	private int semesterId;
//	private int hours;
//	private int minutes;
	private String day;
	private String location;
	private int maxStudents;
	private boolean isActive;
	private Date createdDate;
	private Date modifiedDate;
	private int courseId;
	private String courseTime;
	
	@ManyToOne
	@JoinColumn(name="courseId", nullable=false)
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="semesterId", nullable=false)
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name="offeredByProfId", nullable=false)
	private SystemUser professor;
	
	@OneToMany(mappedBy="courseOffering", fetch=FetchType.EAGER)
	private List<StudentCourseRegistration> registeredStudents;

	//Public Accessors
	
	public List<StudentCourseRegistration> getRegisteredStudents() {
		return registeredStudents;
	}

	public void setRegisteredStudents(
			List<StudentCourseRegistration> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	
	
	public SystemUser getProfessor() {
		return professor;
	}

	public void setProfessor(SystemUser professor) {
		this.professor = professor;
	}
	
	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}
	
	public String getRegStudentCount() {
		if (this.getRegisteredStudents() != null)
		{
			System.out.println("not null");
			return this.maxStudents - registeredStudents.size() + "/" + this.maxStudents;
		}
		return "0/" + this.maxStudents;
	}
	


	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public int getCourseId()
	{
		return this.courseId;
	}
	
	public int getOfferingId()
	{
		return this.offeringId;
	}

	public int getOfferedByProfId()
	{
		return this.offeredByProfId;
	}

	public int getCreatedByAdminId()
	{
		return this.createdByAdminId;
	}

	public Semester getSemester()
	{
		return this.semester;
	}

	public String getLocation()
	{
		return this.location;
	}

	public int getMaxStudents()
	{
		return this.maxStudents;
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
	 * @param offeringId
	 */
	public void setOfferingId(int offeringId)
	{
		this.offeringId = offeringId;
	}

	/**
	 * 
	 * @param offeredByProfId
	 */
	public void setOfferedByProfId(int offeredByProfId)
	{
		this.offeredByProfId = offeredByProfId;
	}

	/**
	 * 
	 * @param createdByAdminId
	 */
	public void setCreatedByAdminId(int createdByAdminId)
	{
		this.createdByAdminId = createdByAdminId;
	}

	/**
	 * 
	 * @param semester
	 */
	public void setSemester(Semester semester)
	{
		this.semester = semester;
	}

	
	/**
	 * 
	 * @param id
	 */
	public void setCourseId(int id)
	{
		this.courseId = id;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}

	/**
	 * 
	 * @param maxStudents
	 */
	public void setMaxStudents(int maxStudents)
	{
		this.maxStudents = maxStudents;
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