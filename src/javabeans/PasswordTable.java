package javabeans;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Database;
import database.Tables;
import tables.User;

public class PasswordTable {
	static Database db = Database.getInstance();
	static User user;
	static byte[] salt;
	static String stringSalt; 
	static String correctPass;

	public static Boolean verifyLogin(String username, String password) {

		// Find a username in the table that matches the username that is trying to log in
		String userQuery = "SELECT * FROM " + Tables.TABLE_USERS + 
				" WHERE " + Tables.USERS_COLUMN_USERNAME + " = '" + username + "';";
		try {
			Statement getItem = db.getConnection().createStatement();
			ResultSet data = getItem.executeQuery(userQuery);
			data.next();
			user = new User(data.getInt(Tables.USERS_COLUMN_ID),
					data.getString(Tables.USERS_COLUMN_USERNAME));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("User could not be found.");
		}

		// Find the entry in the password table that matches the username
		String passQuery = "SELECT * FROM " + Tables.TABLE_PASSWORDS + 
				" WHERE " + Tables.PASSWORDS_COLUMN_USER_ID + " = " + user.getId();
		try {
			Statement getItem = db.getConnection().createStatement();
			ResultSet data = getItem.executeQuery(passQuery);
			data.next();

			// Store the salt and password from the query
			stringSalt = data.getString(Tables.PASSWORDS_COLUMN_SALT);

			correctPass = data.getString(Tables.PASSWORDS_COLUMN_PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Check the users information against whats in the database
		if(correctPass.equals(hashPassword(password, stringSalt))) {

			System.out.println("Password verification successful.");
			return true;
		} else {
			System.out.println("Password verification unsuccessful.");
			return false;
		}
	}


	public static void insertPassword(String password, String salt, int userID) {

		String query = "INSERT INTO " + Tables.TABLE_PASSWORDS + "("
				+ Tables.PASSWORDS_COLUMN_PASSWORD + ", "
				+ Tables.PASSWORDS_COLUMN_SALT + ", "
				+ Tables.PASSWORDS_COLUMN_USER_ID
				+ ") VALUES ('" + password + "','" + salt +  "'," + userID + ");";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Password successfully inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	// Password hashing function
	public static String hashPassword(String password, String salt) {
		// Declare the string builder - this will be used to build the hashed password from bytes into a string
		StringBuilder stringBuild = new StringBuilder();

		try {
			MessageDigest msgDig = MessageDigest.getInstance("sha-256");
			msgDig.update(salt.getBytes());
			byte[] hashBytes = msgDig.digest(password.getBytes());

			for(int i=0; i < hashBytes.length; i++) {
				stringBuild.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return stringBuild.toString();
	}

	// Salt generating function
	public static String getSalt() {
		// Declare the salt
		String salt;
		SecureRandom r = new SecureRandom();
		salt = new BigInteger(64,r).toString();
		System.out.println(salt);

		return salt;
	}




}
