package course.elg5191.university.beans.session;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import course.elg5191.university.beans.entity.Semester;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */

@Local
public interface SemesterSession {

	/**
	 * 
	 * @param semesterId
	 */
	public Semester getSemesterBySemesterId(int semesterId);

	/**
	 * 
	 * @param semester
	 */
	public void addSemester(Semester semester);

	/**
	 * 
	 * @param beginDate
	 */
	public Semester getSemesterByBeginDate(Date beginDate);

	/**
	 * 
	 * @param endDate
	 */
	public Semester getSemesterByEndDate(Date endDate);
	
	public List<String> getAllSemesters();

}