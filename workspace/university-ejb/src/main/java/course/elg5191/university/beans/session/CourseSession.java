package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Local;
import course.elg5191.university.beans.entity.Course;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */

@Local
public interface CourseSession {

	public List<Course> getAllCourses();

	/**
	 * 
	 * @param courseId
	 */
	public Course getCourseByCourseId(int courseId);

	/**
	 * 
	 * @param name
	 */
	public Course getCourseByName(String name);

	/**
	 * 
	 * @param course
	 */
	public void addCourse(Course course);

	/**
	 * 
	 * @param departmentCode
	 */
	public List<Course> getAllCourseByDepartmentCode(String departmentCode);

}