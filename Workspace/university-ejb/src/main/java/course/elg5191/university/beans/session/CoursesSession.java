package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Local;
import course.elg5191.university.beans.entity.Courses;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */

@Local
public interface CoursesSession {

	public List<Courses> getAllCourses();
	
	public List<String> getAllDepartments();

	/**
	 * 
	 * @param name
	 */
	public Courses getCoursesByName(String name);

	/**
	 * 
	 * @param departmentCode
	 */
	public List<Courses> getAllCourseByDepartmentCode(String departmentCode);
	
	public void createCourse(Courses course);
	public void updateCourse(Courses course);
	public void deleteCourse(Courses course);
	public Courses getByCourseId(int courseId);
	
}