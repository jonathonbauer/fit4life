package main;

import tables.User;

/**
 * 
 * This class will be used to hold the active session with the user.
 * It's primary purpose is to hold the user that is currently logged in,
 * so that it may be referenced later on in the application.
 * This also allows us to log the user out when they choose.
 * This class follows the Singleton Design Pattern.
 * 
 *
 */
public class Session {
	
	private static Session session = null;
	private User loggedInUser;
	
	/**
	 * This constructor instantiates the logged in user and creates a new Session
	 * 
	 * @param user The user that is to be logged in to the application
	 */
	public Session(User user) {
		this.loggedInUser = user;
	}
	
	/**
	 * This method is used to return the Session, and if it doesn't exist it will create one
	 * @param user The user to be logged in to the application
	 * @return The active Session object
	 */
	public static Session getInstance(User user) {
		if(session == null) {
			session = new Session(user);
			return session;
		} else {
			return session;
		}
	}
	
	/**
	 * This method is used to return the Session if it has already been created and doesn't require
	 * a user to be logged in
	 * @return The active Session object
	 */
	public static Session getInstance() {
		if(session == null) {
			session = new Session(new User("null"));
		}
		return session;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
	/**
	 * This method is used to determine if there is currently a user logged into the session.
	 * @return True or false depending on whether or not there is a user logged into the session.
	 */
	public static Boolean isLoggedIn() {
		if(session == null || session.getLoggedInUser().getUsername().equals("null")) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * This is method is used to disconnect the user from the session.
	 */
	public void logOut() {
		this.loggedInUser = null;
		System.out.println("User successfully logged out.");
	}
	
	
}
