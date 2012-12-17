package course.elg5191.university.beans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.StudentCourseRegistration;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Stateless(name = "StudentCourseRegistrationSession")
public class StudentCourseRegistrationSessionImpl implements StudentCourseRegistrationSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	//Public Methods
	/**
	 * 
	 * @param registrationId
	 */
	@Override
	public StudentCourseRegistration getStudentCourseRegistrationByRegistrationId(int registrationId)
	{
		return null;
	}

	/**
	 * 
	 * @param studentCourseRegistration
	 */
	@Override
	public void addStudentCourseRegistration(StudentCourseRegistration studentCourseRegistration)
	{

	}

	@Override
	public int getNumberRegisteredForOffering(int offeringId) {
		
		System.out.println(offeringId);
		Query query = em.createQuery("select count(s) from STUDENTCOURSEREGISTRATION s where s.offeredCourseId = :offeringId");
		query.setParameter("offeringId", offeringId);
		
		System.out.println(query.toString());
		
		return ((Number)query.getSingleResult()).intValue();
	}

}