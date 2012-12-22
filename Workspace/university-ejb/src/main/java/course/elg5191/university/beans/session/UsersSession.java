package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Local;
import course.elg5191.university.beans.entity.Users;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */

@Local
public interface UsersSession {

	/**
	 * 
	 * @param user
	 */
	public void addUser(Users user);

	public List<Users> getAllUsers();

	/**
	 * 
	 * @param name
	 */
	public Users getUserByName(String name);

	public void createUser(Users user);
	public void updateUser(Users user);
	public void deleteUser(Users user);

	/**
	 * 
	 * @param id
	 */
	public Users getUserById(int id);
	
	public List<Users> getAllProfs();

 	//Tim
 	public void changeEmailidOfSystemUser(int studentId, String emailid);
 	public void changeAddressOfSystemUser(int studentId, String address);
 	//End	
}