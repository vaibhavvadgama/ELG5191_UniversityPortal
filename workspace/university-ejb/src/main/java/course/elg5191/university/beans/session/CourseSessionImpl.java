package course.elg5191.university.beans.session;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
public class CourseSessionImpl implements CourseSession {

	public CourseSessionImpl(){

	}

	public void finalize() throws Throwable {

	}

	public List<Course> getAllCourses(){
		return null;
	}

	/**
	 * 
	 * @param courseId
	 */
	public Course getCourseByCourseId(int courseId){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public Course getCourseByName(String name){
		return null;
	}

	/**
	 * 
	 * @param course
	 */
	public void addCourse(Course course){

	}

	/**
	 * 
	 * @param departmentCode
	 */
	public List<Course> getAllCourseByDepartmentCode(String departmentCode){
		return null;
	}

}