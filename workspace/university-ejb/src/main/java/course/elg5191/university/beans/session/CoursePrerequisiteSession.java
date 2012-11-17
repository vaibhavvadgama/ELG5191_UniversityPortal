package course.elg5191.university.beans.session;

import javax.ejb.Local;
import course.elg5191.university.beans.entity.CoursePrerequisite;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */

@Local
public interface CoursePrerequisiteSession {

	/**
	 * 
	 * @param prereqId
	 */
	public CoursePrerequisite getCoursePrerequisiteByPrereqId(int prereqId);

	/**
	 * 
	 * @param coursePrerequisite
	 */
	public void addCoursePrerequisite(CoursePrerequisite coursePrerequisite);

}