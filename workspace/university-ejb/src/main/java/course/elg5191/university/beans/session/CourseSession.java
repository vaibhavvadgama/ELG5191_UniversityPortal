package course.elg5191.university.beans.session;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
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