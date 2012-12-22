package course.elg5191.university.ui;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import static course.elg5191.university.util.Messages.addFlashMessage;
import course.elg5191.university.beans.entity.Courses;
import course.elg5191.university.beans.session.CoursesSession;

@RequestScoped
@ManagedBean(name = "deleteCourse")
public class DeleteCourse {
	
	private Courses course;
	
	@EJB
	private CoursesSession courseSI;
	
	public String delete() {
		courseSI.deleteCourse(course);
		addFlashMessage("Course: " + course.getDepartmentCode() + course.getCourseNumber() + " (id: " + course.getCourseId() + ") was deleted successfully.");
		return "retrieve_courses.xhtml?faces-redirect=true";
	}
	
	public String cancel() {
		return "index?faces-redirect=true";
	}
	
	public Courses getCourse() {
		return course;
	}
	
	public void setCourse(Courses course) {
		this.course = course;
	}
}
