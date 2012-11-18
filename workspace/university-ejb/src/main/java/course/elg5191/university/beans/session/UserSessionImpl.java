package course.elg5191.university.beans.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.User;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Stateless(name = "UserSession")
public class UserSessionImpl implements UserSession 
{
	//Declarations
	@PersistenceContext
	EntityManager em;
	
	//Constructors
	public UserSessionImpl()
	{

	}

	//Public Methods
	/**
	 * 
	 * @param user
	 */
	@Override
	public void addUser(User user)
	{

	}

	@Override
	public List<User> getAllUsers()
	{
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	@Override
	public User getUserByName(String name)
	{
		return null;
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public User getUserById(int id)
	{
		return null;
	}

}