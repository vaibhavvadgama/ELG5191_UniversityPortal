package course.elg5191.university.beans.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.Semester;
import course.elg5191.university.beans.entity.Users;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Stateless(name = "SemesterSession")
public class SemesterSessionImpl implements SemesterSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	//Public Methods
	/**
	 * 
	 * @param semesterId
	 */
	@Override
	public Semester getSemesterBySemesterId(int semesterId)
	{
		System.out.println("SemesterSession:: getSemesterBySemesterId");
		
		//Step 1: Define Query
		Query query = em.createQuery("select s from Semester s where s.semesterId=:semesterId");
		query = query.setParameter("semesterId", semesterId);
		
		//Step 2: Obtain the results of the query
		@SuppressWarnings("unchecked")
		List<Semester> semesters = query.getResultList();
		
		//Step 3: Return the results
		if (semesters.size() > 0)
			return semesters.get(0);
		return null;
	}

	/**
	 * 
	 * @param semester
	 */
	@Override
	public void addSemester(Semester semester)
	{
		System.out.println("SemesterSession:: addSemester");
		em.persist(semester);
	}

	/**
	 * 
	 * @param beginDate
	 */
	@Override
	public Semester getSemesterByBeginDate(Date beginDate)
	{
		return null;
	}

	/**
	 * 
	 * @param endDate
	 */
	@Override
	public Semester getSemesterByEndDate(Date endDate)
	{
		System.out.println("SemesterSession:: getSemesterByEndDate");
		
		return null;
	}
	
	@Override
	public List<Semester> getAllSemesters()
	{
		System.out.println("SemesterSession:: getAllSemesters");
		
		//Step 1: Define Query
		Query query = em.createQuery("select s from Semester s where s.endDate > CURRENT_TIMESTAMP");
		
		//Step 2: Obtain the results of the query
		@SuppressWarnings("unchecked")
		List<Semester> semesters = query.getResultList();
		
		//Step 3: Return the results
		return semesters;
	}

}