package course.elg5191.university.beans.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.SystemUser;
import course.elg5191.university.University.UserRole;

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
		System.out.println("SystemUserSessionImpl:: addUser");
		
		//Step 1: Persist the object
		em.persist(user);
	}

	@Override
	public List<SystemUser> getAllUsers()
	{
		System.out.println("SystemUserSessionImpl:: getAllUsers");
		
		//Step 1: Define Query
		Query query = em.createQuery("select s from SystemUser");
		
		//Step 2: Obtain the results of the query
		@SuppressWarnings("unchecked")
		List<SystemUser> users = query.getResultList();
		
		//Step 3: Return the results
		if (users.size() > 0)
		{
			System.out.println("Found users");
			return users;
		}
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	@Override
	public SystemUser getUserByName(String name)
	{
		System.out.println("SystemUserSessionImpl:: getUserByName");
		
		//Step 1: Define Query
		Query query = em.createQuery("select s from SystemUser s where s.name=:name");
		query = query.setParameter("name", name);
		
		//Step 2: Obtain the results of the query
		@SuppressWarnings("unchecked")
		List<SystemUser> users = query.getResultList();
		
		//Step 3: Return the results
		if (users.size() > 0)
		{
			System.out.println("Found user by name");
			return users.get(0);
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public SystemUser getUserById(int id)
	{
		System.out.println("SystemUserSessionImpl:: getUserById");
		
		//Step 1: Define Query
		Query query = em.createQuery("select s from SystemUser s where s.id=:id");
		query = query.setParameter("id", id);
		
		//Step 2: Obtain the results of the query
		@SuppressWarnings("unchecked")
		List<SystemUser> users = query.getResultList();
		
		//Step 3: Return the results
		if (users.size() > 0)
		{
			System.out.println("Found user");
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public List<String> getAllProfs()
	{
		Query query = em.createQuery("select c.name from SystemUser c where c.role=:role");
		query.setParameter("role", UserRole.valueOf("Professor"));
		
		@SuppressWarnings("unchecked")
		List<String> allDepts = query.getResultList();
		
		return allDepts;
	}

}