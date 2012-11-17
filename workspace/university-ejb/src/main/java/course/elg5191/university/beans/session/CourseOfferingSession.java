package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Local;
import course.elg5191.university.beans.entity.CourseOffering;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */
@Local
public interface CourseOfferingSession {

	/**
	 * 
	 * @param offeringId
	 */
	public CourseOffering getCourseOfferingByOfferingId(int offeringId);

	/**
	 * 
	 * @param courseOffering
	 */
	public void addCourseOffering(CourseOffering courseOffering);

	/**
	 * 
	 * @param semester
	 */
	public List<CourseOffering> getAllCourseOfferingBySemester(int semester);

}