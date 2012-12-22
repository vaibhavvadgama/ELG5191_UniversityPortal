package course.elg5191.university.beans.session;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.University.UserRole;

/**
 * @author jmccausl
 * @version 1.0
 * @created 16-Nov-2012 11:34:03 AM
 */
@Stateless(name = "SystemUserSession")
public class UsersSessionImpl implements UsersSession 
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
	public void addUser(Users user)
	{
		System.out.println("SystemUserSessionImpl:: addUser");
		
		//Step 1: Persist the object
		em.persist(user);
	}

	@Override
	public List<Users> getAllUsers()
	{
		System.out.println("SystemUserSessionImpl:: getAllUsers");
		
		//Step 1: Define Query
		Query query = em.createQuery("select s from Users s");
		
		//Step 2: Obtain the results of the query
		@SuppressWarnings("unchecked")
		List<Users> users = query.getResultList();
		
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
	public Users getUserByName(String name)
	{
		System.out.println("SystemUserSessionImpl:: getUserByName");
		
		//Step 1: Define Query
		Query query = em.createQuery("select s from Users s where s.name=:name");
		query = query.setParameter("name", name);
		
		//Step 2: Obtain the results of the query
		@SuppressWarnings("unchecked")
		List<Users> users = query.getResultList();
		
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
	public Users getUserById(int id)
	{
		if (em.find(Users.class, id) != null)
			return (Users) em.find(Users.class, id);
		else
			return new Users();
	}
	
	@Override
	public List<Users> getAllProfs()
	{
		Query query = em.createQuery("select c from Users c where c.role=:role");
		query.setParameter("role", "professor");
		
		List<Users> allProfs = query.getResultList();
		
		return allProfs;
	}
	//Tim
 	public void changeEmailidOfSystemUser(int studentId, String emailid)
 	{
 		Users systemUser = this.getUserById(studentId);
 		systemUser.setEmailid(emailid);
 	}
	//End
 	//Tim
 	public void changeAddressOfSystemUser(int studentId, String address)
 	{
 		Users systemUser = this.getUserById(studentId);
 		systemUser.setAddress(address);
 	}
	//End

	@Override
	public void createUser(Users user) {
		String newSalt = getSalt();
		user.setSalt(newSalt);
		em.persist(user);
		try {
			hashPassword(user, newSalt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(Users user) {
		em.merge(user);
		try {
			hashPassword(user, user.getSalt());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(Users user) {
		user = em.find(Users.class, user.getUserId());
		em.remove(user);
		
	}
	
	public void hashPassword(Users user, String salt) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = null;
		messageDigest = MessageDigest.getInstance("SHA");
		messageDigest.update((user.getPassword() + salt).getBytes());
		String hashedPassword = (new BigInteger(messageDigest.digest())).toString(16);
		user.setPassword(hashedPassword);
		em.merge(user);
	}

	public String getSalt() {
		Date now = new Date();
		return "" + now.getTime();
	}
}