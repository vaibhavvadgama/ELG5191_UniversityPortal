package course.elg5191.university.beans.session;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
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

}