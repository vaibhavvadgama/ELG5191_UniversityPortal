package course.elg5191.university.beans.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.Courses;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Stateless(name = "CourseSession")
public class CoursesSessionImpl implements CoursesSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Courses> getAllCourses() {
		Query query = em.createQuery("select c from Courses c");
		@SuppressWarnings("unchecked")

		List<Courses> allCourses = query.getResultList();
		return allCourses;
		}

	@Override
	public Courses getCoursesByName(String name) {
		Query query = em.createQuery("select c from Courses c where c.name=:name");
		query = query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Courses> courses = query.getResultList();
		//assumes we have only one course with a given name
		//not something which should be assumed in real software (or a course project)
		if (courses.size() > 0)
			return courses.get(0);
		else
			return null;
	}
	
	@Override
	public List<String> getAllDepartments()
	{
		System.out.println("CourseSession:: getAllDepartments()");
		
		Query query = em.createQuery("select distinct c.departmentCode from Courses c");
		
		List<String> allDepts = query.getResultList();
		
		System.out.println(allDepts.get(0));
		
		return allDepts;
	}

	/**
	 * 
	 * @param departmentCode
	 */
	@Override
	public List<Courses> getAllCourseByDepartmentCode(String departmentCode)
	{
		
		Query query = em.createQuery("select c from Courses c where c.departmentCode = '" + departmentCode+"'");
		
		List<Courses> allDepts = query.getResultList();
		
		System.out.println(allDepts.get(0));
		
		return allDepts;
	}
	
	@Override
	public void createCourse(Courses course) {
		em.persist(course);
	}

	@Override
	public void updateCourse(Courses course) {
		em.merge(course);	
	}

	@Override
	public void deleteCourse(Courses course) {
		course = em.find(Courses.class, course.getCourseId());
		em.remove(course);
	}

	@Override
	public Courses getByCourseId(int courseId) {
		if (em.find(Courses.class, courseId) != null)
			return (Courses) em.find(Courses.class, courseId);
		else
			return new Courses();
	}
}