package course.elg5191.university.beans.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.University.StudentCourseRegistrationStatus;
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
		System.out.println("StudentCourseRegistrationSessionImpl:: getStudentCourseRegistrationByRegistrationId");
		
		Query query = em.createQuery("select c from StudentCourseRegistration c where c.registrationId=:registrationId");
		query = query.setParameter("registrationId", registrationId);
		
		@SuppressWarnings("unchecked")
		List<StudentCourseRegistration> courseRegistrations = query.getResultList();
		
		if (courseRegistrations.size() > 0)
			return courseRegistrations.get(0);
		return null;
	}

	/**
	 * 
	 * @param studentCourseRegistration
	 */
	@Override
	public void addStudentCourseRegistration(StudentCourseRegistration studentCourseRegistration)
	{
		System.out.println("StudentCourseRegistrationSessionImpl:: addStudentCourseRegistration");
		em.persist(studentCourseRegistration);
	}
	
	@Override
	public List<StudentCourseRegistration> getStudentCourseRegistrationsByStatus(StudentCourseRegistrationStatus status)
	{	
		System.out.println("StudentCourseRegistrationSessionImpl:: getStudentCourseRegistrationByStatus");
		
		Query query = em.createQuery("select c from StudentCourseRegistration c where c.status=:status");
		query = query.setParameter("status", StudentCourseRegistrationStatus.Current);
		
		@SuppressWarnings("unchecked")
		List<StudentCourseRegistration> courseRegistrations = query.getResultList();
		
		return courseRegistrations;
	}

	@Override
	public int getNumberRegisteredForOffering(int offeringId) {
		
		System.out.println(offeringId);
		Query query = em.createQuery("select count(s) from StudentCourseRegistration s where s.offeredCourseId = :offeringId");
		query.setParameter("offeringId", offeringId);
		
		System.out.println(query.toString());
		
		return ((Number)query.getSingleResult()).intValue();
	}

	public void changeStatusOfCourseRegistration(int registrationId, StudentCourseRegistrationStatus status)
	{
		StudentCourseRegistration studentCourseRegistration = this.getStudentCourseRegistrationByRegistrationId(registrationId);
		studentCourseRegistration.setStatus(status);
	}
	//Tim
	@Override
	public List<StudentCourseRegistration> getStudentCourseRegistrationsByStudentId( int studentId )
	{	
		System.out.println("StudentCourseRegistrationSessionImpl::getStudentCourseRegistrationByStudentId");
		
		Query query = em.createQuery("select c from StudentCourseRegistration c where c.studentId=:studentId");
		query = query.setParameter("studentId", studentId);
		
		@SuppressWarnings("unchecked")
		List<StudentCourseRegistration> courseRegistrations = query.getResultList();
		
		return courseRegistrations;
	}
	//End	
	
}