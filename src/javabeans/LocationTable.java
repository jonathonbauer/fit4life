package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.LocationDAO;
import database.Database;
import database.Tables;
import tables.Location;
import tables.User;

public class LocationTable implements LocationDAO {
	
	//database connection
	Database db = Database.getInstance();
	ArrayList<Location> locations;
	Location location;

	@Override
	public ArrayList<Location> getAllLocations() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM " + Tables.TABLE_LOCATIONS;
        locations = new ArrayList<Location>();

        try {
            Statement getLocations = db.getConnection().createStatement();
            ResultSet data;
            data = getLocations.executeQuery(query);
            while(data.next()) {
                locations.add(new Location(data.getInt(Tables.LOCATIONS_COLUMN_ID),
                                        data.getString(Tables.LOCATIONS_COLUMN_NAME),
                                        data.getString(Tables.LOCATIONS_COLUMN_ADDRESS),
                                        data.getString(Tables.LOCATIONS_COLUMN_POSTAL),
                                        data.getString(Tables.LOCATIONS_COLUMN_CITY)
                        ));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        } 
		return locations;
	}

	@Override
	public Location getLocation(int locationID) {
		String query = "SELECT * FROM " + Tables.TABLE_LOCATIONS + " WHERE "
                + Tables.LOCATIONS_COLUMN_ID + " = " + locationID;

		try {
            Statement getLocations = db.getConnection().createStatement();
            ResultSet data;
            data = getLocations.executeQuery(query);
           data.next();
                location = new Location(data.getInt(Tables.LOCATIONS_COLUMN_ID),
                                        data.getString(Tables.LOCATIONS_COLUMN_NAME),
                                        data.getString(Tables.LOCATIONS_COLUMN_ADDRESS),
                                        data.getString(Tables.LOCATIONS_COLUMN_POSTAL),
                                        data.getString(Tables.LOCATIONS_COLUMN_CITY));
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return location;
	}
	
//	public User getUser(int userID) {
//		String query = "SELECT * FROM " + Tables.TABLE_LOCATIONS + 
//				" WHERE " + Tables.LOCATIONS_COLUMN_ID + " = " + userID;
//		try {
//			Statement getItem = db.getConnection().createStatement();
//			ResultSet data = getItem.executeQuery(query);
//			data.next();
//			user = new User(data.getInt(Tables.USERS_COLUMN_ID),
//					data.getString(Tables.USERS_COLUMN_USERNAME),
//					data.getString(Tables.USERS_COLUMN_PASSWORD));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
//	}


	@Override
	public void updateLocation(Location location) {
		// TODO Auto-generated method stub
		String query = "UPDATE " + Tables.TABLE_LOCATIONS + " SET "
                + Tables.LOCATIONS_COLUMN_NAME + " " + location.getName() + "," 
                + Tables.LOCATIONS_COLUMN_ADDRESS + " " + location.getAddress() + ","
                + Tables.LOCATIONS_COLUMN_POSTAL + " " + location.getPostalCode() + ","
                + Tables.LOCATIONS_COLUMN_CITY + " " + location.getCity() + ","
                + " WHERE " + Tables.LOCATIONS_COLUMN_ID + " " + location.getId();
        try {
            Statement updateLocation = db.getConnection().createStatement();
            ResultSet data;
            data = updateLocation.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void deleteLocation(Location location) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM " + Tables.TABLE_LOCATIONS + " WHERE "
                + Tables.LOCATIONS_COLUMN_ID + " = " + location.getId();
        System.out.println("Location has been deleted.");
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void createLocation(Location location) {
		// TODO Auto-generated method stub
		 String query = "INSERT INTO " + Tables.TABLE_LOCATIONS + "("
                 + Tables.LOCATIONS_COLUMN_NAME
                 + Tables.LOCATIONS_COLUMN_ADDRESS
                 + Tables.LOCATIONS_COLUMN_POSTAL
                 + Tables.LOCATIONS_COLUMN_CITY
                 + ") VALUES ('" + location.getName() + "," + location.getAddress() + ","  
                 + location.getPostalCode() + "," + location.getCity() + "');";
		 	try {
		 		db.getConnection().createStatement().execute(query);
		 		System.out.println("Location successfully created.");
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		
	}

}
