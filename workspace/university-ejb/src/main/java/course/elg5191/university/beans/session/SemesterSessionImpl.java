package course.elg5191.university.beans.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.Semester;

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
		return null;
	}

	/**
	 * 
	 * @param semester
	 */
	@Override
	public void addSemester(Semester semester)
	{

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
		return null;
	}
	
	@Override
	public List<String> getAllSemesters()
	{
		List<String> result = new ArrayList<String>();
		Query query = em.createQuery("select s from Semester s");
		
		List<Semester> semesters = query.getResultList();
		
		for(int i =0; i< semesters.size(); i++)
		{
			Semester s = semesters.get(i);
			
			result.add(s.getTerm() + " - " + s.getYear() );
		}
	
		
		return result;
	}

}