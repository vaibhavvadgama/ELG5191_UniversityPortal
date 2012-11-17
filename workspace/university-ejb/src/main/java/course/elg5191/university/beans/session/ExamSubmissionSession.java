package course.elg5191.university.beans.session;

import javax.ejb.Local;
import course.elg5191.university.beans.entity.ExamSubmission;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */

@Local
public interface ExamSubmissionSession {

	/**
	 * 
	 * @param submissionId
	 */
	public ExamSubmission getExamSubmissionBySubmissionId(int submissionId);

	/**
	 * 
	 * @param examSubmission
	 */
	public void addExamSubmission(ExamSubmission examSubmission);

}