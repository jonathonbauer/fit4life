package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.LocationDAO;
import database.Database;
import database.Tables;
import tables.Location;

/**
 * This class is used to hold all CRUD functionality for the Location table in
 * the database
 *
 */
public class LocationTable implements LocationDAO {

	// database connection
	Database db = Database.getInstance();
	ArrayList<Location> locations;
	Location location;
	CityTable cityTable = new CityTable();

	/**
	 * This method is used to retrieve all Locations in the database
	 * 
	 * @return An arraylist of Location objects
	 */
	public ArrayList<Location> getAllLocations() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM " + Tables.TABLE_LOCATIONS;
		locations = new ArrayList<Location>();

		try {
			Statement getLocations = db.getConnection().createStatement();
			ResultSet data;
			data = getLocations.executeQuery(query);
			while (data.next()) {
				locations.add(new Location(data.getInt(Tables.LOCATIONS_COLUMN_ID),
						data.getString(Tables.LOCATIONS_COLUMN_NAME), data.getString(Tables.LOCATIONS_COLUMN_ADDRESS),
						data.getString(Tables.LOCATIONS_COLUMN_POSTAL),
						this.cityTable.getCity(data.getInt(Tables.MEMBERS_COLUMN_CITY))));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return locations;
	}

	/**
	 * This method is used to get a single Location using its ID
	 * 
	 * @param locationID
	 *            is the ID of the location we wish to retrieve
	 * 
	 * @return A single Location object
	 */
	public Location getLocation(int locationID) {
		String query = "SELECT * FROM " + Tables.TABLE_LOCATIONS + " WHERE " + Tables.LOCATIONS_COLUMN_ID + " = "
				+ locationID;

		try {
			Statement getLocations = db.getConnection().createStatement();
			ResultSet data;
			data = getLocations.executeQuery(query);
			data.next();
			location = new Location(data.getInt(Tables.LOCATIONS_COLUMN_ID),
					data.getString(Tables.LOCATIONS_COLUMN_NAME), data.getString(Tables.LOCATIONS_COLUMN_ADDRESS),
					data.getString(Tables.LOCATIONS_COLUMN_POSTAL),
					this.cityTable.getCity(data.getInt(Tables.LOCATIONS_COLUMN_CITY)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return location;
	}

	/**
	 * This method is used to update an location in the database
	 * 
	 * @param location
	 *            an Location object to be updated
	 * 
	 */
	public void updateLocation(Location location) {
		// TODO Auto-generated method stub
		String query = "UPDATE " + Tables.TABLE_LOCATIONS + " SET " + Tables.LOCATIONS_COLUMN_NAME + " = '"
				+ location.getName() + "'," + Tables.LOCATIONS_COLUMN_ADDRESS + " = '" + location.getAddress() + "',"
				+ Tables.LOCATIONS_COLUMN_POSTAL + " = '" + location.getPostalCode() + "',"
				+ Tables.LOCATIONS_COLUMN_CITY + " = '" + location.getCity().getId() + "'" + " WHERE "
				+ Tables.LOCATIONS_COLUMN_ID + " = " + location.getId();
		try {
			Statement updateLocation = db.getConnection().createStatement();
			updateLocation.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to delete an location out of the database
	 * 
	 * @param location
	 *            an Location object to be deleted
	 * 
	 */
	public void deleteLocation(Location location) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM " + Tables.TABLE_LOCATIONS + " WHERE " + Tables.LOCATIONS_COLUMN_ID + " = "
				+ location.getId();
		System.out.println("Location has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method is used to insert an location in the database
	 * 
	 * @param location
	 *            the Location object to be created
	 * 
	 */
	  public void createLocation(Location location) {

	        String query = "INSERT INTO " + Tables.TABLE_LOCATIONS + "(" + Tables.LOCATIONS_COLUMN_NAME
	                + "," + Tables.LOCATIONS_COLUMN_ADDRESS + "," + Tables.LOCATIONS_COLUMN_POSTAL + "," + Tables.LOCATIONS_COLUMN_CITY
	                + ") VALUES ('" + location.getName() + "','" + location.getAddress() + "','" + location.getPostalCode()
	                + "','" + location.getCity().getId() + "');";
	        try {
	            db.getConnection().createStatement().execute(query);
	            System.out.println("Location successfully created.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
}
