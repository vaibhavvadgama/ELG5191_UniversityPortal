package course.elg5191.university.beans.session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.CourseOffering;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */

@Stateless(name = "CourseOfferingSession")
public class CourseOfferingSessionImpl implements CourseOfferingSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;

	//Public Methods
	/**
	 * 
	 * @param offeringId
	 */
	@Override
	public CourseOffering getCourseOfferingByOfferingId(int offeringId)
	{
		Query query = em.createQuery("select s from CourseOffering s where s.offeringId=:offeringId");
		query = query.setParameter("offeringId",offeringId);
		
		@SuppressWarnings("unchecked")
		List<CourseOffering> courseOfferings = query.getResultList();
		
		if(courseOfferings.size() > 0)
			return courseOfferings.get(0);
		else
			return null;
	}

	/**
	 * 
	 * @param courseOffering
	 */
	@Override
	public void addCourseOffering(CourseOffering courseOffering)
	{
		em.persist(courseOffering);
	}

	/**
	 * 
	 * @param semester
	 */
	@Override
	public List<CourseOffering> getAllCourseOfferingBySemester(int semester)
	{
		Query query = em.createQuery("select s from CourseOffering s where s.semester=:semester");
		query = query.setParameter("semester",semester);
		
		@SuppressWarnings("unchecked")
		List<CourseOffering> courseOfferings = query.getResultList();
		
		return courseOfferings;
		
	}
	
	@Override
	public List<CourseOffering> getCourseOfferingByCourseId(int courseId)
	{
		Query query = em.createQuery("select s from CourseOffering s where s.courseId =:courseId");
		query = query.setParameter("courseId",courseId);
		
		@SuppressWarnings("unchecked")
		List<CourseOffering> courseOfferings = query.getResultList();
		
		return courseOfferings;
	}

	@Override
	public List<CourseOffering> searchCourseOffering(String[] department, String[] semester,
			String[] professor, String courseNumber) {
		
		
		System.out.println("course offering search");
		StringBuilder queryTxt = new StringBuilder("select co from CourseOffering co where ");
		
		if ((department != null) && (department.length != 0))
		{
			queryTxt.append("co.course.departmentCode in :department and ");
		}
		
		if ((semester != null) && (semester.length != 0))
		{
			queryTxt.append("co.semester in :semester and " );
		}
		
		if ((professor != null) && (professor.length != 0))
		{
			queryTxt.append("co.offeredByProfId in :professor and " );
		}
		
		if (!courseNumber.isEmpty())
		{
			queryTxt.append("co.course.courseNumber = '" + courseNumber + "'");
		}else
		{
			queryTxt.delete(queryTxt.length()-5, queryTxt.length());
		}
		
		System.out.println(queryTxt);
		Query query = em.createQuery(queryTxt.toString());

		if ((department != null) && (department.length != 0))
		{
			query.setParameter("department", Arrays.asList(department));
		}
		
		if ((semester != null) && (semester.length != 0))
		{
			query.setParameter("semester", Arrays.asList(semester));
		}
		
		if ((professor != null) && (professor.length != 0))
		{
			query.setParameter("professor", Arrays.asList(professor));
		}
		
		@SuppressWarnings("unchecked")
		List<CourseOffering> courseOfferings = new ArrayList();
		
		courseOfferings = query.getResultList();
		
		
		return courseOfferings;
		
	}

}