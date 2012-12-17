package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Local;
import course.elg5191.university.beans.entity.StudentCourseRegistration;
import course.elg5191.university.University.StudentCourseRegistrationStatus;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */

@Local
public interface StudentCourseRegistrationSession 
{

	/**
	 * 
	 * @param registrationId
	 * @return
	 */
	public StudentCourseRegistration getStudentCourseRegistrationByRegistrationId(int registrationId);

	/**
	 * 
	 * @param studentCourseRegistration
	 */
	public void addStudentCourseRegistration(StudentCourseRegistration studentCourseRegistration);
	
    public int getNumberRegisteredForOffering(int offeringId);

	/**
	 * 
	 * @param status
	 * @return
	 */
	public List<StudentCourseRegistration> getStudentCourseRegistrationsByStatus(StudentCourseRegistrationStatus status);
	
	public void changeStatusOfCourseRegistration(int registrationId, StudentCourseRegistrationStatus status);
}