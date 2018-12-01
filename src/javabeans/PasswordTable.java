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




/**
 *	The PasswordTable class has three functions;
 *	<ul>
 *		<li>verifyLogin which is used to check a users log in credentials against the stored credentials.</li>
 *		<li>hashPassword which is used to hash the users password on user creation</li>
 *		<li>getSalt which is used to securely generate a random salt for the user's password hashing</li>
 *	</ul>
 * 
 * 	This class follows the Singleton pattern.
 * 	<br/>
 * 
 * @author Jonathon Bauer
 * 
 */
public class PasswordTable {
	static Database db = Database.getInstance();
	static User user;
	static byte[] salt;
	static String stringSalt; 
	static String correctPass;
	
	/**
	 * This method takes in the users information, and matches it against information within the database.
	 * <br/>
	 * If the database has a matching user, the program will then hash the inputted password using the
	 * salt that matches the username that matched. 
	 * <br/>
	 * If the hashed password matches the stored hashed password, the method returns true.
	 * <br/>
	 * If the database does not contain a matching user, or the password does not match, the method returns false.
	 * 
	 * 
	 * @param username The username in String form that the user has entered
	 * @param password The password in String form that the user has entered.
	 * @return True or false depending on whether or not the user has inputted correct credentials.
	 */
	public static Boolean verifyLogin(String username, String password) {
		
		// Find a username in the table that matches the username that is trying to log in
		String userQuery = "SELECT * FROM " + Tables.TABLE_USERS + 
				" WHERE " + Tables.USERS_COLUMN_USERNAME + " = '" + username + "';";
		try {
			Statement getItem = db.getConnection().createStatement();
			ResultSet data = getItem.executeQuery(userQuery);
			if(!data.next()) {
				return false;
			}
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
		
		// Check the users information against what's in the database
		if(correctPass.equals(hashPassword(password, stringSalt))) {
			
			System.out.println("Password verification successful.");
			return true;
		} else {
			System.out.println("Password verification unsuccessful.");
			return false;
		}
	}
	
	
	
	
	/**
	 * This method uses an SQL query to insert the hashed password, salt and matching userID into the database
	 * 
	 * @param password The hashed password to be stored in the database.
	 * @param salt The salt used to hash the password.
	 * @param userID The userID of the matching User for the password and salt.
	 */
	public static void insertPassword(String password, String salt, int userID) {

		 String query = "INSERT INTO " + Tables.TABLE_PASSWORDS + "("
                 + Tables.PASSWORDS_COLUMN_PASSWORD + ", "
                 + Tables.PASSWORDS_COLUMN_SALT + ", "
                 + Tables.PASSWORDS_COLUMN_USER_ID
                 + ") VALUES ('" + password + "','" + salt +  "'," + userID + ");";
		 	try {
		 		db.getConnection().createStatement().execute(query);
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		
	}
	
	
	/**
	 *	This method uses MessageDigest with sha-256 encryption to hash a password.
	 *	<br/>
	 *	It adds the salt to the MessageDigest object which then converts the password into bytes and generates the hashed password, stored in a byte array.
	 *  <br/>
	 *	The method then uses a StringBuilder object to convert the byte array into a String.
	 *	<br/>
	 *  This string is then returned from the function.  
	 * 
	 * @param password The password to be hashed.
	 * @param salt The salt that is going to be used to hash the password.
	 * @return The hashed password stored in a String
	 * @see StringBuilder 
	 * @see MessageDigest
	 */
	public static String hashPassword(String password, String salt) {
		// Declare the string builder - this will be used to build the hashed password from bytes into a string
		StringBuilder stringBuild = new StringBuilder();

		try {
			// Create a MessageDigest object and set its algorithm to sha-256
			MessageDigest msgDig = MessageDigest.getInstance("sha-256");
			
			// Add the salt in byte form to the MessageDigest object
			msgDig.update(salt.getBytes());
			
			// Hash the provided password and store it in a byte array
			byte[] hashBytes = msgDig.digest(password.getBytes());
			
			// Use a StringBuilder object to convert the byte array into an object that can be turned into a string
			for(int i=0; i < hashBytes.length; i++) {
				stringBuild.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// Return the string version of the hashed password
		return stringBuild.toString();
	}
	
	
	/**
	 * This method uses a SecureRandom object to create a random number securely.
	 * <br/>
	 * This random number is used to generate a 64 digit BigInteger object which is then converted to a string.
	 * <br/>
	 * This string is then returned from the function.
	 * 
	 * @return A string that is 64 characters in length that has been securely generated.
	 */
	public static String getSalt() {
		
		// Declare the string salt that will be used to store the salt
		String salt;
		
		// Generate a SecureRandom number to be used to generate the salt
		SecureRandom r = new SecureRandom();
		
		// Create a new BigInteger of length 64 using the random number generated and set its string value to the salt variable
		salt = new BigInteger(64,r).toString();
		
		// Return the salt
		return salt;
	}
	
	
	
	
}
