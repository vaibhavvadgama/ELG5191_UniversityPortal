package course.elg5191.university.ui;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.faces.bean.ManagedBean;

import course.elg5191.university.beans.entity.Course;
import course.elg5191.university.beans.session.CourseSession;

@ManagedBean(name = "courseDetailsBean")
@ViewScoped
public class CourseDetailsBean {
	
	// Properties ---------------------------------------------------------------------------------
    private Course course;
    private int courseId;

    // Services -----------------------------------------------------------------------------------



	@EJB
    private CourseSession courseSess;
    
    // Actions ------------------------------------------------------------------------------------

    public void init() {

        course = courseSess.getCourseByCourseId(courseId);
    }

    // Getters/setters ----------------------------------------------------------------------------

    public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

    public Course getCourse() {
        return course;
    }

}
