package course.elg5191.university.beans.session;
import course.elg5191.university.beans.entity.User;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
public interface UserSession {

	/**
	 * 
	 * @param user
	 */
	public void addUser(User user);

	public List<User> getAllUsers();

	/**
	 * 
	 * @param name
	 */
	public User getUserByName(String name);

	/**
	 * 
	 * @param id
	 */
	public User getUserById(int id);

}