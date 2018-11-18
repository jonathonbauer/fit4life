package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.CityDAO;
import database.Database;
import database.Tables;
import tables.City;

public class CityTable implements CityDAO {
	// Get the database connection
	Database db = Database.getInstance();
	ArrayList<City> citys;
	City city;
	
	
	@Override
	public ArrayList<City> getAllCities() {
		String query = "SELECT * FROM " + Tables.TABLE_CITIES; 
		citys = new ArrayList<City>();

		try {
			Statement getCitys = db.getConnection().createStatement();
			ResultSet data;
			data = getCitys.executeQuery(query);
			while(data.next()) {
				citys.add(new City(data.getInt(Tables.CITIES_COLUMN_ID),
						data.getString(Tables.CITIES_COLUMN_CITY)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citys;
	}

	@Override
	public City getCity(int cityID) {
		String query = "SELECT * FROM " + Tables.TABLE_CITIES + 
				" WHERE " + Tables.CITIES_COLUMN_ID + " = " + cityID;
		try {
			Statement getCity = db.getConnection().createStatement();
			ResultSet data = getCity.executeQuery(query);
			data.next();
				city = new City(data.getInt(Tables.CITIES_COLUMN_ID),
					data.getString(Tables.CITIES_COLUMN_CITY));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	@Override
	public void updateCity(City city) {
		String query = "UPDATE " + Tables.TABLE_CITIES + " SET " + 
				Tables.CITIES_COLUMN_CITY + " " + city.getCity() + "," +
				" WHERE " + Tables.CITIES_COLUMN_ID + " = " + city.getId();
		try {
			Statement updateMember = db.getConnection().createStatement();
			updateMember.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteCity(City city) {
		String query = "DELETE FROM " + Tables.TABLE_CITIES + 
				" WHERE " + Tables.CITIES_COLUMN_ID + " = " + city.getId();
		System.out.println("City has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createCity(City city) {
		String query = "INSERT INTO " + Tables.TABLE_CITIES + "("
				+ Tables.CITIES_COLUMN_CITY + ") VALUES ('" 
				+ city.getCity() + "');";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("City has been created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
