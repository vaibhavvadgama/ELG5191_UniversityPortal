package course.elg5191.university.ui;

import javax.faces.event.ActionEvent;

/**
 * @author li
 * Backing bean for course search logic
 *
 */
public class CourseSearchBean {
	
	//private members
	private String[] department;
	private String[] semester;
	private String[] professor;
	private String courseNumber;
	private String hour;
	private String minute;
	
	
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

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	
	
	
	//action handlers
	public void searchCourse(ActionEvent event)
	{
//		searchResults.clear();
//		
//		ArrayList<Course> courseResults = new ArrayList<Course>();
//		ArrayList<CourseOffering> courseOfferingResults = new ArrayList<CourseOffering>();
//		if (department.length > 0)
//		{	
//			for(String dep : department)
//			{
//				courseResults.addAll( courseSess.getAllCourseByDepartmentCode(dep));
//			}
//			
//			for(Course course: courseResults)
//			{
//				courseOfferingResults.addAll(courseOfferingSess.getCourseOfferingByCourseId(course.getCourseId()));
//			}
//
//		}
//		
////		if (semester.length >0)
////		{
////			for(String sem :semester)
////			{
////				courseOfferingSess.getAllCourseOfferingBySemester(semester)
////			}
////		}
//		searchResults.addAll(courseOfferingResults);
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		try {
//			ec.redirect("CourseSearchResult.xhtml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//return "CourseSearchResult?faces-redirect=true";
		
	}
}
