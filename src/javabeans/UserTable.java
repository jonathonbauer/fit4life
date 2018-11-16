package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import daos.UserDAO;
import database.Database;
import database.Tables;
import tables.User;

/**
 * 
 * This class will be used to manipulate the Users table in the database
 *
 */
public class UserTable implements UserDAO {
	Database db = Database.getInstance();
	ArrayList<User> users;
	User user;




	public ArrayList<User> getAllUsers() {
		String query = "SELECT * FROM " + Tables.TABLE_USERS; 
		users = new ArrayList<User>();

		try {
			Statement getUsers = db.getConnection().createStatement();
			ResultSet data;
			data = getUsers.executeQuery(query);
			while(data.next()) {
				users.add(new User(data.getInt(Tables.USERS_COLUMN_ID),
						data.getString(Tables.USERS_COLUMN_USERNAME),
						data.getString(Tables.USERS_COLUMN_PASSWORD)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}


	public User getUser(int userID) {
		String query = "SELECT * FROM " + Tables.TABLE_USERS + 
				" WHERE " + Tables.USERS_COLUMN_ID + " = " + userID;
		try {
			Statement getItem = db.getConnection().createStatement();
			ResultSet data = getItem.executeQuery(query);
			data.next();
			user = new User(data.getInt(Tables.USERS_COLUMN_ID),
					data.getString(Tables.USERS_COLUMN_USERNAME),
					data.getString(Tables.USERS_COLUMN_PASSWORD));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(User user) {
		String query = "UPDATE " + Tables.TABLE_USERS + " SET " + 
				Tables.USERS_COLUMN_USERNAME + " " + user.getUsername() + "," +
				Tables.USERS_COLUMN_PASSWORD + " " + user.getPassword() + "," +
				" WHERE " + Tables.USERS_COLUMN_ID + " = " + user.getId();
		try {
			Statement updateUser = db.getConnection().createStatement();
			updateUser.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void deleteUser(User user) {
		String query = "DELETE FROM " + Tables.TABLE_USERS + 
				" WHERE " + Tables.USERS_COLUMN_ID + " = " + user.getId();
		System.out.println("User has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createUser(User user) {
		String query = "INSERT INTO " + Tables.TABLE_USERS + "("
				+ Tables.USERS_COLUMN_USERNAME + ", " 
				+ Tables.USERS_COLUMN_PASSWORD + ") VALUES ('" 
				+ user.getUsername() + "','" + user.getPassword() + "');";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("User has been created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

