package course.elg5191.university.beans.session;

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

}