package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * This class will be used to represent the connection to the Database.
 * It will implement the Singleton design pattern to ensure that we
 * are only ever using one connection at any given time.
 *
 */
public class Database {

	public static Database instance = null;
	private Connection connection = null;
	
	// Constructor
	private Database() {
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/" + Tables.DB_NAME + "?useSSL=false", "user", "password");
				System.out.println("Successfully connected to the database.");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			createTable(Tables.TABLE_MEMBERS, Tables.CREATE_TABLE_MEMBERS, connection);
			createTable(Tables.TABLE_CITIES, Tables.CREATE_TABLE_CITIES, connection);
			createTable(Tables.TABLE_LOCATIONS, Tables.CREATE_TABLE_LOCATIONS, connection);
			createTable(Tables.TABLE_AMENITIES, Tables.CREATE_TABLE_AMENITIES, connection);
			createTable(Tables.TABLE_MEMBER_LEVEL, Tables.CREATE_TABLE_MEMBER_LEVEL, connection);
			createTable(Tables.TABLE_MANAGERS, Tables.CREATE_TABLE_MANAGERS, connection);
			createTable(Tables.TABLE_LOCATION_AMENITIES, Tables.CREATE_TABLE_LOCATION_AMENITIES, connection);
			createTable(Tables.TABLE_MEMBER_AMENITIES, Tables.CREATE_TABLE_MEMBER_AMENITIES, connection);
			createTable(Tables.TABLE_MANAGER_LOCATIONS, Tables.CREATE_TABLE_MANAGER_LOCATIONS, connection);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// getConnection method
	public Connection getConnection() {
		return connection;
	}
	
	
	// getInstance method
	public static Database getInstance() {
		if(instance == null) {
			instance = new Database();
			return instance;
		} else {
			return instance;
		}
	}
	
	/**
	 * This method will be used to create the tables when the application is launched and initialized
	 * 
	 * @param table is the name of the table we will be creating
	 * @param query is the query that will be used to create the table
	 * @param connection will represent the connection to the database
	 * @throws SQLException is thrown in the event there is an error with the query or connection
	 */
	
	public void createTable(String table, String query, Connection connection) throws SQLException {
		// Statement that will be used if the tables don't already exist
		Statement statement;
		
		// Get the metadata from the database
		DatabaseMetaData metadata = connection.getMetaData();
		
		// Get the data if the table exists
		ResultSet result = metadata.getTables(null, null, table, null);
		
		// Test if the table exists, create it if it does not
		if(result.next()) {
			System.out.println(table + "already exists.");
		} else {
			statement = connection.createStatement();
			statement.execute(query);
			System.out.println(table + " has been successfully created.");
		}
		
		
		
		
	}
	
}
