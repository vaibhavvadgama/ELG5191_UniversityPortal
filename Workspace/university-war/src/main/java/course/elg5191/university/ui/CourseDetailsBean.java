package course.elg5191.university.ui;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.faces.bean.ManagedBean;

import course.elg5191.university.beans.entity.Courses;
import course.elg5191.university.beans.session.CoursesSession;

@ManagedBean(name = "courseDetailsBean")
@ViewScoped
public class CourseDetailsBean {
	
	// Properties ---------------------------------------------------------------------------------
    private Courses course;
    private int courseId;

    // Services -----------------------------------------------------------------------------------



	@EJB
    private CoursesSession courseSess;
    
    // Actions ------------------------------------------------------------------------------------

    public void init() {

        course = courseSess.getByCourseId(courseId);
    }

    // Getters/setters ----------------------------------------------------------------------------

    public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

    public Courses getCourse() {
        return course;
    }

}
