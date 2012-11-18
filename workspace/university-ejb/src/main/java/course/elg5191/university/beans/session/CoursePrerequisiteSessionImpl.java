package course.elg5191.university.beans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.CoursePrerequisite;


/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:02 AM
 */

@Stateless(name = "CoursePrerequisiteSession")
public class CoursePrerequisiteSessionImpl implements CoursePrerequisiteSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	//Constructor
	public CoursePrerequisiteSessionImpl()
	{

	}

	//Public Methods
	/**
	 * 
	 * @param prereqId
	 */
	@Override
	public CoursePrerequisite getCoursePrerequisiteByPrereqId(int prereqId){
		return null;
	}

	/**
	 * 
	 * @param coursePrerequisite
	 */
	@Override
	public void addCoursePrerequisite(CoursePrerequisite coursePrerequisite){

	}

}