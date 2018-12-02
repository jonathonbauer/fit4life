package database;

/**
 * 
 * This class will be used to hold all the constants that represent the table
 * and column names in the database It will also hold constants for the create
 * table queries
 *
 */

public class Tables {

	// Database Name
	public static final String DB_NAME = "fit4life";

	// Users Table

	public static final String TABLE_USERS = "users";
	public static final String USERS_COLUMN_ID = "id";
	public static final String USERS_COLUMN_USERNAME = "username";

	public static final String TABLE_PASSWORDS = "passwords";
	public static final String PASSWORDS_COLUMN_PASSWORD = "password";
	public static final String PASSWORDS_COLUMN_SALT = "salt";
	public static final String PASSWORDS_COLUMN_USER_ID = "user_id";

	// Members Table
	public static final String TABLE_MEMBERS = "members";
	public static final String MEMBERS_COLUMN_ID = "id";
	public static final String MEMBERS_COLUMN_FNAME = "first_name";
	public static final String MEMBERS_COLUMN_LNAME = "last_name";
	public static final String MEMBERS_COLUMN_ADDRESS = "address";
	public static final String MEMBERS_COLUMN_POSTALCODE = "postal_code";
	public static final String MEMBERS_COLUMN_CITY = "city";
	public static final String MEMBERS_COLUMN_ACTIVE_MEMBERSHIP = "active_membership";
	public static final String MEMBERS_COLUMN_MEMBERSHIP_LEVEL = "membership_level";
	public static final String MEMBERS_COLUMN_LOCATION = "location";
	public static final String MEMBERS_COLUMN_REGISTRATION_DATE = "registration_date";

	// Cities Table
	public static final String TABLE_CITIES = "cities";
	public static final String CITIES_COLUMN_ID = "id";
	public static final String CITIES_COLUMN_CITY = "city";

	// Locations Table
	public static final String TABLE_LOCATIONS = "locations";
	public static final String LOCATIONS_COLUMN_ID = "id";
	public static final String LOCATIONS_COLUMN_NAME = "name";
	public static final String LOCATIONS_COLUMN_ADDRESS = "address";
	public static final String LOCATIONS_COLUMN_POSTAL = "postal_code";
	public static final String LOCATIONS_COLUMN_CITY = "city";

	// Amenities Table
	public static final String TABLE_AMENITIES = "amenities";
	public static final String AMENITIES_COLUMN_ID = "id";
	public static final String AMENITIES_COLUMN_AMENITY = "amenity";

	// Member Level Table
	public static final String TABLE_MEMBER_LEVEL = "member_levels";
	public static final String MEMBER_LEVELS_COLUMN_ID = "id";
	public static final String MEMBER_LEVELS_COLUMN_NAME = "name";

	// Managers Table
	public static final String TABLE_MANAGERS = "managers";
	public static final String MANAGERS_COLUMN_ID = "id";
	public static final String MANAGERS_COLUMN_FNAME = "first_name";
	public static final String MANAGERS_COLUMN_LNAME = "last_name";
	public static final String MANAGERS_COLUMN_ADDRESS = "address";
	public static final String MANAGERS_COLUMN_POSTALCODE = "postal_code";
	public static final String MANAGERS_COLUMN_CITY = "city";

	// Location Amenities Table
	public static final String TABLE_LOCATION_AMENITIES = "location_amenities";
	public static final String LOCATION_AMENITIES_COLUMN_LOCATION = "location";
	public static final String LOCATION_AMENITIES_COLUMN_AMENITY = "amenity";

	// Member Amenities Table
	public static final String TABLE_MEMBER_AMENITIES = "member_amenities";
	public static final String MEMBER_AMENITIES_COLUMN_MEMBER_LEVEL = "member_level";
	public static final String MEMBER_AMENITIES_COLUMN_AMENITY = "amenity";

	// Manager Locations
	public static final String TABLE_MANAGER_LOCATIONS = "manager_locations";
	public static final String MANAGER_LOCATIONS_COLUMN_MANAGER = "manager";
	public static final String MANAGER_LOCATIONS_COLUMN_LOCATION = "location";

	// Create Table Queries

	public static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + "(" + USERS_COLUMN_ID
			+ " int NOT NULL AUTO_INCREMENT, " + USERS_COLUMN_USERNAME + " VARCHAR(50), " + "PRIMARY KEY("
			+ USERS_COLUMN_ID + "));";

	public static final String CREATE_TABLE_PASSWORDS = "CREATE TABLE " + TABLE_PASSWORDS + "("
			+ PASSWORDS_COLUMN_PASSWORD + " VARCHAR(100), " + PASSWORDS_COLUMN_SALT + " VARCHAR(100), "
			+ PASSWORDS_COLUMN_USER_ID + " int NOT NULL, " + "FOREIGN KEY (" + PASSWORDS_COLUMN_USER_ID
			+ ") REFERENCES " + TABLE_USERS + "(" + USERS_COLUMN_ID + "));";

	public static final String CREATE_TABLE_MEMBERS = "CREATE TABLE " + TABLE_MEMBERS + "(" + MEMBERS_COLUMN_ID
			+ " int NOT NULL AUTO_INCREMENT, " + MEMBERS_COLUMN_FNAME + " VARCHAR(50), " + MEMBERS_COLUMN_LNAME
			+ " VARCHAR(50), " + MEMBERS_COLUMN_ADDRESS + " VARCHAR(50), " + MEMBERS_COLUMN_POSTALCODE
			+ " VARCHAR(50), " + MEMBERS_COLUMN_CITY + " int NOT NULL, " + MEMBERS_COLUMN_ACTIVE_MEMBERSHIP
			+ " BOOLEAN, " + MEMBERS_COLUMN_MEMBERSHIP_LEVEL + " int NOT NULL, " + MEMBERS_COLUMN_LOCATION
			+ " int NOT NULL, " + MEMBERS_COLUMN_REGISTRATION_DATE + " DATE, " + "FOREIGN KEY (" + MEMBERS_COLUMN_CITY
			+ ") REFERENCES " + TABLE_CITIES + "(" + CITIES_COLUMN_ID + ")," + "FOREIGN KEY (" + MEMBERS_COLUMN_LOCATION
			+ ") REFERENCES " + TABLE_LOCATIONS + "(" + LOCATIONS_COLUMN_ID + ")," + "FOREIGN KEY ("
			+ MEMBERS_COLUMN_MEMBERSHIP_LEVEL + ") REFERENCES " + TABLE_MEMBER_LEVEL + "(" + MEMBER_LEVELS_COLUMN_ID
			+ ")," + "PRIMARY KEY(" + MEMBERS_COLUMN_ID + "));";

	public static final String CREATE_TABLE_CITIES = "CREATE TABLE " + TABLE_CITIES + "(" + CITIES_COLUMN_ID
			+ " int NOT NULL AUTO_INCREMENT, " + CITIES_COLUMN_CITY + " VARCHAR(50), " + "PRIMARY KEY("
			+ CITIES_COLUMN_ID + "));";

	public static final String CREATE_TABLE_LOCATIONS = "CREATE TABLE " + TABLE_LOCATIONS + "(" + LOCATIONS_COLUMN_ID
			+ " int NOT NULL AUTO_INCREMENT, " + LOCATIONS_COLUMN_NAME + " VARCHAR(50), " + LOCATIONS_COLUMN_ADDRESS
			+ " VARCHAR(50), " + LOCATIONS_COLUMN_POSTAL + " VARCHAR(50), " + LOCATIONS_COLUMN_CITY + " int NOT NULL, "
			+ "FOREIGN KEY (" + LOCATIONS_COLUMN_CITY + ") REFERENCES " + TABLE_CITIES + "(" + CITIES_COLUMN_ID + "),"
			+ "PRIMARY KEY(" + LOCATIONS_COLUMN_ID + "));";

	public static final String CREATE_TABLE_AMENITIES = "CREATE TABLE " + TABLE_AMENITIES + "(" + AMENITIES_COLUMN_ID
			+ " int NOT NULL AUTO_INCREMENT, " + AMENITIES_COLUMN_AMENITY + " VARCHAR(50), " + "PRIMARY KEY("
			+ AMENITIES_COLUMN_ID + "));";

	public static final String CREATE_TABLE_MEMBER_LEVEL = "CREATE TABLE " + TABLE_MEMBER_LEVEL + "("
			+ MEMBER_LEVELS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " + MEMBER_LEVELS_COLUMN_NAME + " VARCHAR(50), "
			+ "PRIMARY KEY(" + MEMBER_LEVELS_COLUMN_ID + "));";

	public static final String CREATE_TABLE_MANAGERS = "CREATE TABLE " + TABLE_MANAGERS + "(" + MANAGERS_COLUMN_ID
			+ " int NOT NULL AUTO_INCREMENT, " + MANAGERS_COLUMN_FNAME + " VARCHAR(50), " + MANAGERS_COLUMN_LNAME
			+ " VARCHAR(50), " + MANAGERS_COLUMN_ADDRESS + " VARCHAR(50), " + MANAGERS_COLUMN_POSTALCODE
			+ " VARCHAR(50), " + MANAGERS_COLUMN_CITY + " int NOT NULL, " + "FOREIGN KEY (" + MANAGERS_COLUMN_CITY
			+ ") REFERENCES " + TABLE_CITIES + "(" + CITIES_COLUMN_ID + ")," + "PRIMARY KEY(" + MANAGERS_COLUMN_ID
			+ "));";

	public static final String CREATE_TABLE_LOCATION_AMENITIES = "CREATE TABLE " + TABLE_LOCATION_AMENITIES + "("
			+ LOCATION_AMENITIES_COLUMN_LOCATION + " int NOT NULL, " + LOCATION_AMENITIES_COLUMN_AMENITY
			+ " int NOT NULL, " + "FOREIGN KEY (" + LOCATION_AMENITIES_COLUMN_LOCATION + ") REFERENCES "
			+ TABLE_LOCATIONS + "(" + LOCATIONS_COLUMN_ID + ")," + "FOREIGN KEY (" + LOCATION_AMENITIES_COLUMN_AMENITY
			+ ") REFERENCES " + TABLE_AMENITIES + "(" + AMENITIES_COLUMN_ID + "));";

	public static final String CREATE_TABLE_MEMBER_AMENITIES = "CREATE TABLE " + TABLE_MEMBER_AMENITIES + "("
			+ MEMBER_AMENITIES_COLUMN_MEMBER_LEVEL + " int NOT NULL, " + MEMBER_AMENITIES_COLUMN_AMENITY
			+ " int NOT NULL, " + "FOREIGN KEY (" + MEMBER_AMENITIES_COLUMN_MEMBER_LEVEL + ") REFERENCES "
			+ TABLE_MEMBER_LEVEL + "(" + MEMBER_LEVELS_COLUMN_ID + ")," + "FOREIGN KEY ("
			+ MEMBER_AMENITIES_COLUMN_AMENITY + ") REFERENCES " + TABLE_AMENITIES + "(" + AMENITIES_COLUMN_ID + "));";

	public static final String CREATE_TABLE_MANAGER_LOCATIONS = "CREATE TABLE " + TABLE_MANAGER_LOCATIONS + "("
			+ MANAGER_LOCATIONS_COLUMN_MANAGER + " int NOT NULL, " + MANAGER_LOCATIONS_COLUMN_LOCATION
			+ " int NOT NULL, " + "FOREIGN KEY (" + MANAGER_LOCATIONS_COLUMN_MANAGER + ") REFERENCES " + TABLE_MANAGERS
			+ "(" + MANAGERS_COLUMN_ID + ")," + "FOREIGN KEY (" + MANAGER_LOCATIONS_COLUMN_LOCATION + ") REFERENCES "
			+ TABLE_LOCATIONS + "(" + LOCATIONS_COLUMN_ID + "));";

}
