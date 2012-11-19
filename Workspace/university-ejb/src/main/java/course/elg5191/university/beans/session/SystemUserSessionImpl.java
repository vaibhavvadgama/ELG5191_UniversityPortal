package course.elg5191.university.beans.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.SystemUser;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Stateless(name = "SystemUserSession")
public class SystemUserSessionImpl implements SystemUserSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	//Public Methods
	/**
	 * 
	 * @param user
	 */
	@Override
	public void addUser(SystemUser user)
	{

	}

	@Override
	public List<SystemUser> getAllUsers()
	{
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	@Override
	public SystemUser getUserByName(String name)
	{
		return null;
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public SystemUser getUserById(int id)
	{
		return null;
	}

}