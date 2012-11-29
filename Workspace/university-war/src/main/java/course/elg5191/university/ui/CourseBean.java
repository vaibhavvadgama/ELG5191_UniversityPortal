package course.elg5191.university.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.entity.Course;
import course.elg5191.university.beans.entity.CourseOffering;
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
	private CourseOfferingSession courseOfferingSess;
	@EJB
	private SemesterSession semSess;
	@EJB 
	private SystemUserSession userSess;
	
	private String[] department;
	private String[] semester;
	private String[] professor;
	private ArrayList<CourseOffering> searchResults;
	
	
	public ArrayList<CourseOffering> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(ArrayList<CourseOffering> searchResults) {
		this.searchResults = searchResults;
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

	//Constructor
	public CourseBean()
	{
		searchResults = new ArrayList<CourseOffering>();
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

	
	public String[] getDepartment()
	{
		return department;
	}
	
	public void setDepartment(String[] value)
	{
		department = value;
	}
	
	
	public void searchCourse(ActionEvent event)
	{
		searchResults.clear();
		
		ArrayList<Course> courseResults = new ArrayList<Course>();
		ArrayList<CourseOffering> courseOfferingResults = new ArrayList<CourseOffering>();
		if (department.length > 0)
		{	
			for(String dep : department)
			{
				courseResults.addAll( courseSess.getAllCourseByDepartmentCode(dep));
			}
			
			for(Course course: courseResults)
			{
				courseOfferingResults.addAll(courseOfferingSess.getCourseOfferingByCourseId(course.getCourseId()));
			}

		}
		
//		if (semester.length >0)
//		{
//			for(String sem :semester)
//			{
//				courseOfferingSess.getAllCourseOfferingBySemester(semester)
//			}
//		}
		searchResults.addAll(courseOfferingResults);
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