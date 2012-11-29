package course.elg5191.university.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.entity.Course;
import course.elg5191.university.beans.session.*;

/**
 * @author jmccausl
 * @version 1.0
 * @created 17-Nov-2012 7:13:43 AM
 */
@ManagedBean(name = "courseBean")
@SessionScoped
public class CourseBean 
{
	//Declarations
	@EJB
	private CourseSession courseSess;
	@EJB
	private SemesterSession semSess;
	
	private String[] department;
	private String courseNumber;
	private String semester;
	private String professor;
	private ArrayList<Course> searchResults;
	
	
	public ArrayList<Course> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(ArrayList<Course> searchResults) {
		this.searchResults = searchResults;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	//Constructor
	public CourseBean()
	{
		searchResults = new ArrayList<Course>();
	}
	
	//Public Methods
	public List<String> getDepartments()
	{
		return courseSess.getAllDepartments();
	}
	
	public List<String> getSemesters()
	{
		return semSess.getAllSemesters();
	}
	
	
	
	
	public String getCourseNumber()
	{
		return courseNumber;
	}
	
	public String[] getDepartment()
	{
		return department;
	}
	
	public void setDepartment(String[] value)
	{
		department = value;
	}
	
	public void setCourseNumber(String value)
	{
		courseNumber = value;
	}
	
	
	
	public void searchCourse(ActionEvent event)
	{
		searchResults.clear();

		if (department.length > 0)
		{	
			for(String dep : department)
			{
				searchResults.addAll( courseSess.getAllCourseByDepartmentCode(dep));
			}

		}
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect("CourseSearchResult.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "CourseSearchResult?faces-redirect=true";
		
	}
	
}