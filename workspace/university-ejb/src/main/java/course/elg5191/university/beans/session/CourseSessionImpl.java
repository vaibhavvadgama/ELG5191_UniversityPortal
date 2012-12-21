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
	
	//Public Method
	@Override
	public List<Course> getAllCourses()
	{
		return null;
	}
	
	@Override
	public List<String> getAllDepartments()
	{
		System.out.println("CourseSession:: getAllDepartments()");
		
		Query query = em.createQuery("select distinct c.departmentCode from Course c");
		
		List<String> allDepts = query.getResultList();
		
		System.out.println(allDepts.get(0));
		
		return allDepts;
	}
	
	

	/**
	 * 
	 * @param courseId
	 */
	@Override
	public Course getCourseByCourseId(int courseId)
	{
		Query query = em.createQuery("select c from Course c where c.courseId = :courseId");
		query.setParameter("courseId", courseId);
		
		Course result = (Course)query.getSingleResult();

		
		return result;
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
		
		Query query = em.createQuery("select c from Course c where c.departmentCode = '" + departmentCode+"'");
		
		List<Course> allDepts = query.getResultList();
		
		System.out.println(allDepts.get(0));
		
		return allDepts;
	}

}