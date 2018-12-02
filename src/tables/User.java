package tables;
/**
 * 
 * This class represents a User object from within the database. <br/>
 * It contains the ID and the username of the user.
 * 
 */
public class User {
	private int id;
	private String username;
	
	// Constructors
	public User(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public User(String username) {
		this.username = username;
	}
	
	public User() {
		
	}

	// Getters and Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	
}
