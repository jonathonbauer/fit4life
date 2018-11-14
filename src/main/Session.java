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
	
	
	public Session(User user) {
		this.loggedInUser = user;
	}
	
	// Get instance method used to create a session with a user at log in
	public static Session getInstance(User user) {
		if(session == null) {
			session = new Session(user);
			return session;
		} else {
			return session;
		}
	}
	
	// Get instance method used to get the instance that has already been created at log in
	public static Session getInstance() {
		if(session == null) {
			session = new Session(new User("null", "null"));
			System.out.println("There is no active session.");
		}
		return session;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
	// Method to check if the session is logged in 
	public static Boolean isLoggedIn() {
		if(session == null || session.getLoggedInUser().getUsername().equals("null")) {
			return false;
		} else {
			return true;
		}
		
	}
	
}
