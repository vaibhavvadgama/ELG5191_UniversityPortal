package course.elg5191.university.beans.session;
import course.elg5191.university.beans.entity.User;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
public class UserSessionImpl implements UserSession {

	public UserSessionImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param user
	 */
	public void addUser(User user){

	}

	public List<User> getAllUsers(){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public User getUserByName(String name){
		return null;
	}

	/**
	 * 
	 * @param id
	 */
	public User getUserById(int id){
		return null;
	}

}