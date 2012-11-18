package course.elg5191.university.beans.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.Course;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Stateless(name = "CourseSession")
public class CourseSessionImpl implements CourseSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	//Constructor
	public CourseSessionImpl()
	{

	}

	//Public Method
	@Override
	public List<Course> getAllCourses()
	{
		return null;
	}

	/**
	 * 
	 * @param courseId
	 */
	@Override
	public Course getCourseByCourseId(int courseId)
	{
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	@Override
	public Course getCourseByName(String name)
	{
		return null;
	}

	/**
	 * 
	 * @param course
	 */
	@Override
	public void addCourse(Course course)
	{

	}

	/**
	 * 
	 * @param departmentCode
	 */
	@Override
	public List<Course> getAllCourseByDepartmentCode(String departmentCode)
	{
		return null;
	}

}