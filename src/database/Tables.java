package database;

/**
 * 
 * This class will be used to hold all the constants that represent the table and column names in the database
 * It will also hold constants for the create table queries
 *
 */

public class Tables {
	
	// Database Name
	public static final String DB_NAME = "fit4life";
	
	
	// Members Table
	public static final String TABLE_MEMBERS = "members";
	public static final String MEMBERS_COLUMN_ID = "id";
	public static final String MEMBERS_COLUMN_NAME = "name";
	public static final String MEMBERS_COLUMN_ADDRESS = "address";
	public static final String MEMBERS_COLUMN_POSTALCODE = "postal_code";
	public static final String MEMBERS_COLUMN_CITY = "city";
	public static final String MEMBERS_COLUMN_ACTIVE_MEMBERSHIP = "active_membership";
	public static final String MEMBERS_COLUMN_MEMBERSHIP_LEVEL = "membership_level";
	public static final String MEMBERS_COLUMN_REGISTRATION_DATE = "registration_date";	
	
	// Cities Table	
	public static final String TABLE_CITIES = "location";
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
	public static final String MANAGERS_COLUMN_NAME = "name";
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
	
	public static final String CREATE_TABLE_MEMBERS = "CREATE TABLE " + TABLE_MEMBERS +
	 		"(" + MEMBERS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
	 		MEMBERS_COLUMN_NAME + " VARCHAR(50), " + 
	 		MEMBERS_COLUMN_ADDRESS + " VARCHAR(50), " + 
	 		MEMBERS_COLUMN_POSTALCODE + " VARCHAR(50), " +
	 		MEMBERS_COLUMN_CITY + " int REFERENCES " + 
	 		TABLE_CITIES + "(" + CITIES_COLUMN_ID + ")," +
	 		MEMBERS_COLUMN_ACTIVE_MEMBERSHIP + " BOOLEAN, " +
	 		MEMBERS_COLUMN_MEMBERSHIP_LEVEL + " int REFERENCES " + 
	 		TABLE_MEMBER_LEVEL + "(" + MEMBER_LEVELS_COLUMN_ID + ")," +
	 		MEMBERS_COLUMN_REGISTRATION_DATE + " DATE, " +
	       "PRIMARY KEY(" + MEMBERS_COLUMN_ID + "));"; 
	
	public static final String CREATE_TABLE_CITIES = "CREATE TABLE " + TABLE_CITIES +
			 "(" + CITIES_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			 	CITIES_COLUMN_CITY + " VARCHAR(50), " + 
			     "PRIMARY KEY(" + CITIES_COLUMN_ID + "));";
	
	public static final String CREATE_TABLE_LOCATIONS = "CREATE TABLE " + TABLE_LOCATIONS +
			 "(" + LOCATIONS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			       LOCATIONS_COLUMN_NAME + " VARCHAR(50), " + 
			       LOCATIONS_COLUMN_ADDRESS + " VARCHAR(50), " + 
			       LOCATIONS_COLUMN_ADDRESS + " VARCHAR(50), " +
			       LOCATIONS_COLUMN_POSTAL + " VARCHAR(50), " +
			       LOCATIONS_COLUMN_ADDRESS + " VARCHAR(50), " +
			       LOCATIONS_COLUMN_CITY + " int REFERENCES " + 
			 	   TABLE_CITIES + "(" + CITIES_COLUMN_ID + ")," +
			       "PRIMARY KEY(" + LOCATIONS_COLUMN_ID + "));";
	
	public static final String CREATE_TABLE_AMENITIES = "CREATE TABLE " + TABLE_AMENITIES +
			 "(" + AMENITIES_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			 	   AMENITIES_COLUMN_AMENITY + " VARCHAR(50), " + 
			       "PRIMARY KEY(" + AMENITIES_COLUMN_ID + "));";
	
	public static final String CREATE_TABLE_MEMBER_LEVEL = "CREATE TABLE " + TABLE_MEMBER_LEVEL +
			 "(" + MEMBER_LEVELS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			 	   MEMBER_LEVELS_COLUMN_NAME + " VARCHAR(50), " + 
			       "PRIMARY KEY(" + MEMBER_LEVELS_COLUMN_ID + "));";
	
	public static final String CREATE_TABLE_MANAGERS = "CREATE TABLE " + TABLE_MANAGERS +
			 "(" + MANAGERS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
			 	   MANAGERS_COLUMN_NAME + " VARCHAR(50), " + 
			 	   MANAGERS_COLUMN_ADDRESS + " VARCHAR(50), " + 
			 	   MANAGERS_COLUMN_POSTALCODE + " VARCHAR(50), " +
			 	   MANAGERS_COLUMN_CITY + " int REFERENCES " + 
			 	   TABLE_CITIES + "(" + CITIES_COLUMN_ID + ")," +
			       "PRIMARY KEY(" + MANAGERS_COLUMN_ID + "));";
	
	public static final String CREATE_TABLE_LOCATION_AMENITIES = "CREATE TABLE " + TABLE_LOCATION_AMENITIES +
			  "(" + LOCATION_AMENITIES_COLUMN_LOCATION + " int REFERENCES " + 
			 		TABLE_LOCATIONS + "(" + LOCATIONS_COLUMN_ID + ")," +
			 		LOCATION_AMENITIES_COLUMN_AMENITY + " int REFERENCES " + 
			 		TABLE_AMENITIES + "(" + AMENITIES_COLUMN_ID + "),";
	
	public static final String CREATE_TABLE_MEMBER_AMENITIES = "CREATE TABLE " + TABLE_MEMBER_AMENITIES +
			  "(" + MEMBER_AMENITIES_COLUMN_MEMBER_LEVEL + " int REFERENCES " + 
			  		TABLE_MEMBER_LEVEL + "(" + MEMBER_LEVELS_COLUMN_ID + ")," +
			 		MEMBER_AMENITIES_COLUMN_AMENITY + " int REFERENCES " + 
			 		TABLE_AMENITIES + "(" + AMENITIES_COLUMN_ID + "),";
	
	public static final String CREATE_TABLE_MANAGER_LOCATIONS = "CREATE TABLE " + TABLE_MANAGER_LOCATIONS +
			  "(" + MANAGER_LOCATIONS_COLUMN_MANAGER + " int REFERENCES " + 
			  		TABLE_MANAGERS + "(" + MANAGERS_COLUMN_ID + ")," +
			 		MANAGER_LOCATIONS_COLUMN_LOCATION + " int REFERENCES " + 
			 		TABLE_LOCATIONS + "(" + LOCATIONS_COLUMN_ID + "),";
}
