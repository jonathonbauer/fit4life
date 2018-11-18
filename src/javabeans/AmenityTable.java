package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.AmenityDAO;
import database.Database;
import database.Tables;
import tables.Amenity;

public class AmenityTable implements AmenityDAO {
	//database connection
		Database db = Database.getInstance();
		ArrayList<Amenity> amenities;
		Amenity amenity;

	public ArrayList<Amenity> getAllAmenities() {
		String query = "SELECT * FROM " + Tables.TABLE_AMENITIES;
		amenities = new ArrayList<Amenity>();
		
		try {
			Statement getAmenities = db.getConnection().createStatement();
			ResultSet data;
			data = getAmenities.executeQuery(query);
			while(data.next()) {
				amenities.add(new Amenity(data.getInt(Tables.AMENITIES_COLUMN_ID),
										data.getString(Tables.AMENITIES_COLUMN_AMENITY)
						));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return amenities;
	}

	public Amenity getAmenity(int amenityID) {
		String query = "SELECT * FROM " + Tables.TABLE_AMENITIES + " WHERE "
				+ Tables.AMENITIES_COLUMN_ID + " = " + amenityID;
		amenities = new ArrayList<Amenity>();
		
		try {
			Statement getAmenities = db.getConnection().createStatement();
			ResultSet data;
			data = getAmenities.executeQuery(query);
			while(data.next()) {
				amenities.add(new Amenity(data.getInt(Tables.AMENITIES_COLUMN_ID),
										data.getString(Tables.AMENITIES_COLUMN_AMENITY)
						));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return amenity;
	}

	public void updateAmenity(Amenity amenity) {

		
	}

	public void deleteAmenity(Amenity amenity) {

		
	}

	public void createAmenity(Amenity amenity) {

		
	}

}
