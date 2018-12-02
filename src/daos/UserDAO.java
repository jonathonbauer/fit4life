package daos;

import java.util.ArrayList;

import tables.User;

/**
 * 
 * This data access object is used to tell the UserTable object what
 * functionality it needs to provide.
 * 
 *
 */
public interface UserDAO {

	public ArrayList<User> getAllUsers();

	public User getUser(int userID);

	public void updateUser(User user);

	public void deleteUser(User user);

	public void createUser(User user);
}
