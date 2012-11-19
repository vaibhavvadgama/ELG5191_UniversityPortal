package course.elg5191.university.beans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.Exam;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Stateless(name = "ExamSession")
public class ExamSessionImpl implements ExamSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;

	//Public Methods
	/**
	 * 
	 * @param examId
	 */
	@Override
	public Exam getExamByExamId(int examId)
	{
		return null;
	}

	/**
	 * 
	 * @param exam
	 */
	@Override
	public void addExam(Exam exam)
	{

	}

}