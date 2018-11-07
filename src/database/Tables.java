package database;

/**
 * 
 * This class will be used to hold all the constants that represent the table and column_names in the database
 *
 */

public class Tables {
	
	// Members Table
	public static final String TABLE_MEMBERS = "members";
	public static final String MEMBERS_COLUMN_ID = "id";
	public static final String MEMBERS_COLUMN_NAME = "name";
	public static final String MEMBERS_COLUMN_ADDRESS = "address";
	public static final String MEMBERS_COLUMN_POSTALCODE = "postal_code";
	public static final String MEMBERS_COLUMN_CITY = "city";
	public static final String MEMBERS_COLUMN_ACTIVE_MEMBERSHIP = "active_membership";
	public static final String MEMBERS_COLUMN_MEMBERSHIP_LEVEL_ID = "membership_level";
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
	
	
}
