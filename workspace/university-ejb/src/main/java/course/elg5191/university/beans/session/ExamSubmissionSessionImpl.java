package course.elg5191.university.beans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.ExamSubmission;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Stateless(name = "ExamSubmissionSession")
public class ExamSubmissionSessionImpl implements ExamSubmissionSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	//Public Methods
	/**
	 * 
	 * @param submissionId
	 */
	@Override
	public ExamSubmission getExamSubmissionBySubmissionId(int submissionId)
	{
		return null;
	}

	/**
	 * 
	 * @param examSubmission
	 */
	@Override
	public void addExamSubmission(ExamSubmission examSubmission)
	{

	}

}