package course.elg5191.university.ui;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import course.elg5191.university.beans.entity.*;
import course.elg5191.university.beans.session.CourseOfferingSession;

/**
 * @author li
 * Backing bean for course search logic
 *
 */

@ManagedBean(name = "courseSearchBean")
@SessionScoped
public class CourseSearchBean {
	//session beans
	@EJB
	private CourseOfferingSession courseOfferingSess;
	
	//private members
	private String[] department;
	private String[] semester;
	private String[] professor;
	private String courseNumber;
	private List<CourseOffering> courseSearchResult;
	
	

	//getters and setters
	public String[] getDepartment() {
		return department;
	}
	
	public void setDepartment(String[] department) {
		this.department = department;
	}
	
	public String[] getSemester() {
		return semester;
	}

	public void setSemester(String[] semester) {
		this.semester = semester;
	}

	public String[] getProfessor() {
		return professor;
	}

	public void setProfessor(String[] professor) {
		this.professor = professor;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	public List<CourseOffering> getCourseSearchResult() {
		return courseSearchResult;
	}
	
	//action handlers
	public void clear(ActionEvent event)
	{
		System.out.println("Clear");
		
		this.department = null;
		this.semester = null;
		this.professor = null;
		this.courseNumber = "";
	}
	
	public void searchCourse(ActionEvent event)
	{
		System.out.println("Search Course");
		
		if (courseSearchResult != null)
		{
			courseSearchResult.clear();
			System.out.println("Search Course2");
		}
		
		System.out.println("Search Course2");
		
	    this.courseSearchResult =	courseOfferingSess.searchCourseOffering(department, semester, professor, courseNumber);
		System.out.println(courseSearchResult.size());
	}
}
