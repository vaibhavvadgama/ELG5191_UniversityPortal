package course.elg5191.university.ui;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import static course.elg5191.university.util.Messages.addFlashMessage;
import java.io.Serializable;
import java.util.Date;

import course.elg5191.university.beans.entity.Courses;
import course.elg5191.university.beans.session.CoursesSession;

@SuppressWarnings("serial")
@RequestScoped
@ManagedBean(name = "editCourse")
public class EditCourse implements Serializable{
	private Courses course;
	public EditCourse(){
		course = new Courses();
	}
	
	@EJB
	private CoursesSession courseSI;
	public void preRenderView() {
		if (course == null || course.equals("") || !(course instanceof Courses)) {
			course = new Courses();
		}
	}

	public String saveCourse() {
		if (course.getCourseId() != 0) {
			course.setModifiedDate(new Date());
			courseSI.updateCourse(course);
		}
		else {
			course.setCreatedDate(new Date());
			courseSI.createCourse(course);
		}
		addFlashMessage("Course: " + course.getDepartmentCode() + course.getCourseNumber() + " (id: " + course.getCourseId() + ") was saved successfully.");
		return "retrieve_courses.xhtml?faces-redirect=true";
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public Courses getCourse() {
		return course;
	}
}