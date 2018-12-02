package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javabeans.MemberLevelTable;
import tables.MemberLevel;

/**
 * 
 * This class will be used to represent the connection to the Database. It will
 * contain functionality used to create the tables required in the database.
 * 
 *
 */
public class Database {

	public static Database instance = null;
	private Connection connection = null;

	/**
	 * The constructor of the Database class uses File/IO to read in database
	 * information from the config file. <br/>
	 * It then uses this information to create a connection to the database.
	 * 
	 */
	private Database() {
		// Get the connection info from the config file and put it in an arraylist
		ArrayList<String> config = new ArrayList<>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/main/config.txt"));
			config.add(in.readLine());
			config.add(in.readLine());
			config.add(in.readLine());
			config.add(in.readLine());
			in.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mysql://" + config.get(0) + "/" + config.get(1) + "?useSSL=false", config.get(2),
						config.get(3));
				System.out.println("Successfully connected to the database.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to create all the tables in the database that are
	 * required.
	 * 
	 * @return True if the queries were successful, false if it was not.
	 */
	public Boolean createTables() {
		try {
			createTable(Tables.TABLE_CITIES, Tables.CREATE_TABLE_CITIES, connection);
			createTable(Tables.TABLE_AMENITIES, Tables.CREATE_TABLE_AMENITIES, connection);
			createTable(Tables.TABLE_MEMBER_LEVEL, Tables.CREATE_TABLE_MEMBER_LEVEL, connection);
			createTable(Tables.TABLE_LOCATIONS, Tables.CREATE_TABLE_LOCATIONS, connection);
			createTable(Tables.TABLE_MEMBERS, Tables.CREATE_TABLE_MEMBERS, connection);
			createTable(Tables.TABLE_MANAGERS, Tables.CREATE_TABLE_MANAGERS, connection);
			createTable(Tables.TABLE_USERS, Tables.CREATE_TABLE_USERS, connection);
			createTable(Tables.TABLE_PASSWORDS, Tables.CREATE_TABLE_PASSWORDS, connection);
			
			MemberLevelTable memLevTable = new MemberLevelTable();
			memLevTable.createMemberLevel(new MemberLevel("Gold"));
			memLevTable.createMemberLevel(new MemberLevel("Silver"));
			memLevTable.createMemberLevel(new MemberLevel("Bronze"));
			
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * This method is used to get the active connection to the database.
	 * 
	 * @return The active connection to the database.
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * 
	 * @return True or false depending on whether or not there is an active
	 *         connection
	 */
	public Boolean testConnection() {
		if (connection == null) {
			System.out.println("There is no connection");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method tests if there is an active instance of the Database, and if not
	 * it creates one.
	 * 
	 * @return An instance of the Database class.
	 */
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
			return instance;
		} else {
			return instance;
		}
	}

	/**
	 * This method will be used to create the tables when the application is
	 * launched and initialized
	 * 
	 * @param table
	 *            is the name of the table we will be creating
	 * @param query
	 *            is the query that will be used to create the table
	 * @param connection
	 *            will represent the connection to the database
	 * @throws SQLException
	 *             is thrown in the event there is an error with the query or
	 *             connection
	 */

	public void createTable(String table, String query, Connection connection) throws SQLException {
		// Statement that will be used if the tables don't already exist
		Statement statement;

		// Get the metadata from the database
		DatabaseMetaData metadata = connection.getMetaData();

		// Get the data if the table exists
		ResultSet result = metadata.getTables(null, null, table, null);

		// Test if the table exists, create it if it does not
		if (result.next()) {
			System.out.println(table + " table already exists.");
		} else {
			statement = connection.createStatement();
			statement.execute(query);
			System.out.println(table + " table has been successfully created.");
		}

	}

}
