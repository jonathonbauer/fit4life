package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.AmenityDAO;
import database.Database;
import database.Tables;
import tables.Amenity;

/**
 * This class is used to hold all CRUD functionality for the Amenity table in
 * the database
 *
 */
public class AmenityTable implements AmenityDAO {

	// database connection
	Database db = Database.getInstance();
	ArrayList<Amenity> amenities;
	Amenity amenity;

	/**
	 * This method is used to retrieve all Amenities in the database
	 * 
	 * @return An arraylist of Amenity objects
	 */
	public ArrayList<Amenity> getAllAmenities() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM " + Tables.TABLE_AMENITIES;
		amenities = new ArrayList<Amenity>();

		try {
			Statement getAmenities = db.getConnection().createStatement();
			ResultSet data;
			data = getAmenities.executeQuery(query);
			while (data.next()) {
				amenities.add(new Amenity(data.getInt(Tables.AMENITIES_COLUMN_ID),
						data.getString(Tables.AMENITIES_COLUMN_AMENITY)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return amenities;
	}

	/**
	 * This method is used to get a single Amenity using its ID
	 * 
	 * @param amenityID
	 *            is the ID of the amenity we wish to retrieve
	 * 
	 * @return A single Amenity object
	 */
	public Amenity getAmenity(int amenityID) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM " + Tables.TABLE_AMENITIES + " WHERE " + Tables.AMENITIES_COLUMN_ID + " = "
				+ amenityID;

		try {
			Statement getAmenities = db.getConnection().createStatement();
			ResultSet data;
			data = getAmenities.executeQuery(query);
			while (data.next()) {
				amenities.add(new Amenity(data.getInt(Tables.AMENITIES_COLUMN_ID),
						data.getString(Tables.AMENITIES_COLUMN_AMENITY)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return amenity;
	}

	/**
	 * This method is used to update an amenity in the database
	 * 
	 * @param amenity
	 *            an Amenity object to be updated
	 * 
	 */
	public void updateAmenity(Amenity amenity) {
		// TODO Auto-generated method stub
		String query = "UPDATE " + Tables.TABLE_AMENITIES + " SET " + Tables.AMENITIES_COLUMN_AMENITY + " = '"
				+ amenity.getAmenity() + "'" + " WHERE " + Tables.AMENITIES_COLUMN_ID + " = " + amenity.getId();
		try {
			Statement updateAmenities = db.getConnection().createStatement();
			updateAmenities.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to delete an amenity out of the database
	 * 
	 * @param amenity
	 *            an Amenity object to be deleted
	 * 
	 */
	public void deleteAmenity(Amenity amenity) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM " + Tables.TABLE_AMENITIES + " WHERE " + Tables.AMENITIES_COLUMN_ID + " = "
				+ amenity.getId();
		System.out.println("Amenity has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to insert an amenity in the database
	 * 
	 * @param amenity
	 *            the Amenity object to be created
	 * 
	 */
	public void createAmenity(Amenity amenity) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO " + Tables.TABLE_AMENITIES + "(" + Tables.AMENITIES_COLUMN_AMENITY + ") VALUES ('"
				+ amenity.getAmenity() + "');";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Amenity successfully created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
