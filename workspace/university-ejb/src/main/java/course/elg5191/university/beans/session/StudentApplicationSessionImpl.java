package course.elg5191.university.beans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.StudentApplication;
//Tim
import java.util.List;
//End

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Stateless(name = "StudentApplicationSession")
public class StudentApplicationSessionImpl implements StudentApplicationSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;

	//Public Methods
	/**
	 * 
	 * @param recordId
	 */
	@Override
	public StudentApplication getStudentApplicationByRecordId(int recordId)
	{
		return null;
	}

	/**
	 * 
	 * @param studentApplication
	 */
	@Override
	public void addStudentApplication(StudentApplication studentApplication)
	{

	}
	//Tim
	@Override
	public List<StudentApplication> getStudentApplicationByStudentId(int sid )
	{
		System.out.println("StudentApplicationSessionImpl:: getStudentApplicationByStudentId");
	 		
		Query query = em.createQuery("select c from StudentApplication c where c.studentId=:studentId");
		query = query.setParameter("studentId", sid);
	 		
	@SuppressWarnings("unchecked")
	List<StudentApplication> sa = query.getResultList();
	 		
	return sa;
	}
	//End	

}