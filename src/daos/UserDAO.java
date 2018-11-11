package daos;

import java.util.ArrayList;

import tables.User;

public interface UserDAO {
	
	public ArrayList<User> getAllUsers();
	public User getUser(int userID);
	public void updateUser(User user);
	public void deleteUser(User user);
	public void createUser(User user);
}
