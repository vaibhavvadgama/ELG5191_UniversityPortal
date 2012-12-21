package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Local;
import course.elg5191.university.beans.entity.SystemUser;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */

@Local
public interface SystemUserSession {

	/**
	 * 
	 * @param user
	 */
	public void addUser(SystemUser user);

	public List<SystemUser> getAllUsers();

	/**
	 * 
	 * @param name
	 */
	public SystemUser getUserByName(String name);

	/**
	 * 
	 * @param id
	 */
	public SystemUser getUserById(int id);
	
	public List<SystemUser> getAllProfs();

 	//Tim
 	public void changeEmailidOfSystemUser(int studentId, String emailid);
 	public void changeAddressOfSystemUser(int studentId, String address);
 	//End	
}