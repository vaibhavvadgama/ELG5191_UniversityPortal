package course.elg5191.university.ui;

import static course.elg5191.university.util.Messages.addFlashMessage;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import course.elg5191.university.University.UserRole;
import course.elg5191.university.beans.entity.Users;
import course.elg5191.university.beans.session.UsersSession;
import course.elg5191.university.beans.session.UsersSessionImpl;

@SuppressWarnings("serial")
@RequestScoped
@ManagedBean(name = "userLogin")
public class UserLogin implements Serializable {

	private final String ROLE_STUDENT = "student";
	private final String ROLE_PROFESSOR = "professor";
	private final String ROLE_ADMINISTRATOR = "administrator";

	private List<Users> users;

	private Users user;
	private UsersSessionImpl userService;
	private Users currentUser;
	private UserSession session;

	public UserLogin() {
		user = new Users();
		session = new UserSession();
		if(session.getLoggedUser() != null) {
			user = session.getLoggedUser();
		}
	}

	public UsersSessionImpl getUserService() {
		return userService;
	}

	public void setUserService(UsersSessionImpl userService) {
		this.userService = userService;
	}

	public Users getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

	@EJB
	private UsersSession userSI;

	public void preRenderView() {
		if (user == null || user.equals("") || !(user instanceof Users)) {
			user = new Users();
		}
	}

	@PostConstruct
	public void init() {
		users = userSI.getAllUsers();
	}

	public List<Users> getUsers() {
		return users;
	}

	public String initiateUserLogin() {
		String status = "";

		boolean isCorrectLogin = false;
		boolean isUserFound = false;
		Users loggedUser = null;

		List<Users> systemUsers = getUsers();
		for (Users systemUserBean : systemUsers) {
			if (systemUserBean.getEmailid().equals("" + user.getEmailid())) {
				String currentHashedPassword = preparePassword(
						user.getPassword(), systemUserBean);
				isUserFound = true;
				System.out.println(currentHashedPassword);
				System.out.println(systemUserBean.getPassword());
				if (systemUserBean.getPassword().equals(currentHashedPassword)) {
					isCorrectLogin = true;
				}
				loggedUser = systemUserBean;
				initSession(loggedUser);
			}
		}

		if (isUserFound == true) {
			if (isCorrectLogin) {
				if (loggedUser.getRole().equals(ROLE_STUDENT)) {
//					addFlashMessage("" + loggedUser.getEmailId());
					status = "StudentWelcome.xhtml?faces-redirect=true&loggedUser="
							+ loggedUser.getEmailid()
							+ "&userRole="
							+ loggedUser.getRole();
				} else if (loggedUser.getRole().equals(ROLE_PROFESSOR)) {
//					addFlashMessage("" + loggedUser.getEmailId());
					status = "professorhome.xhtml?faces-redirect=true&loggedUser="
							+ loggedUser.getEmailid()
							+ "&userRole="
							+ loggedUser.getRole();
				} else if (loggedUser.getRole().equals(ROLE_ADMINISTRATOR)) {
//					addFlashMessage("" + loggedUser.getEmailId());
					status = "home.xhtml?faces-redirect=true&loggedUser="
							+ loggedUser.getEmailid() + "&userRole="
							+ loggedUser.getRole();
				}
			} else {
				addFlashMessage("Invalid password! Wrong login credentials for user "
						+ user.getEmailid());
				status = "securelogin.xhtml?faces-redirect=true&loggedUser="
						+ loggedUser.getEmailid();
			}

		} else {
			addFlashMessage("Invalid user! No records found for user, "
					+ user.getEmailid());
			status = "securelogin.xhtml?faces-redirect=true&loggedUser="
					+ user.getEmailid();
		}

		return status;
	}

	public void initSession(Users loggedUser) {
		session.initSession(loggedUser);
	}

	public void printLoggedUserDetails() {
		try {
			Users loggedUser = session.getLoggedUser();
			System.out.println("Logged User : " + loggedUser.getUserId() + " "
					+ loggedUser.getEmailid());
		} catch (Exception e) {
			System.out.println("Logged User : No User Logged In");
		}
	}

	public String destroySession() {
		session.destroySession();
		return "securelogin.xhtml?faces-redirect=true";
	}

	public String preparePassword(String plainPassword, Users userToCompare) {
		String hashedPassword = "";
		try {
			MessageDigest messageDigest = null;
			messageDigest = MessageDigest.getInstance("SHA");
			messageDigest.update((plainPassword + userToCompare.getSalt())
					.getBytes());
			hashedPassword = (new BigInteger(messageDigest.digest()))
					.toString(16);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Problem in Hashing password");
		}
		return hashedPassword;
	}

}
