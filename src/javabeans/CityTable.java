package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.CityDAO;
import database.Database;
import database.Tables;
import tables.City;

/**
 * This class is used to hold all CRUD functionality for the City table in the
 * database
 *
 */
public class CityTable implements CityDAO {
	// Get the database connection
	Database db = Database.getInstance();
	ArrayList<City> citys;
	City city;
	String cityName;

	/**
	 * This method is used to retrieve all Cities in the database
	 * 
	 * @return An arraylist of City objects
	 */
	public ArrayList<City> getAllCities() {
		String query = "SELECT * FROM " + Tables.TABLE_CITIES;
		citys = new ArrayList<City>();

		try {
			Statement getCitys = db.getConnection().createStatement();
			ResultSet data;
			data = getCitys.executeQuery(query);
			while (data.next()) {
				citys.add(new City(data.getInt(Tables.CITIES_COLUMN_ID), data.getString(Tables.CITIES_COLUMN_CITY)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citys;
	}

	/**
	 * This method is used to retrieve all City names in the database
	 * 
	 * @return An arraylist of City names in String form
	 */
	public ArrayList<String> getAllCityNames() {
		String query = "SELECT " + Tables.CITIES_COLUMN_CITY + " FROM " + Tables.TABLE_CITIES;
		ArrayList<String> cities = new ArrayList<String>();

		try {
			Statement getCitys = db.getConnection().createStatement();
			ResultSet data;
			data = getCitys.executeQuery(query);
			while (data.next()) {
				cities.add(data.getString(Tables.CITIES_COLUMN_CITY));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}

	/**
	 * This method is used to get a single City using its ID
	 * 
	 * @param cityID
	 *            is the ID of the city we wish to retrieve
	 * 
	 * @return A single City object
	 */
	public City getCity(int cityID) {
		String query = "SELECT * FROM " + Tables.TABLE_CITIES + " WHERE " + Tables.CITIES_COLUMN_ID + " = " + cityID;
		try {
			Statement getCity = db.getConnection().createStatement();
			ResultSet data = getCity.executeQuery(query);
			data.next();
			city = new City(data.getInt(Tables.CITIES_COLUMN_ID), data.getString(Tables.CITIES_COLUMN_CITY));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	/**
	 * This method is used to get the name of a City using its ID
	 * 
	 * @param cityID
	 *            the ID of the City we want to retrieve the String name of
	 * @return the String value of the City name
	 */
	public String getCityName(int cityID) {
		String query = "SELECT " + Tables.CITIES_COLUMN_CITY + " FROM " + Tables.TABLE_CITIES + " WHERE "
				+ Tables.CITIES_COLUMN_ID + " = " + cityID;
		try {
			Statement getCity = db.getConnection().createStatement();
			ResultSet data = getCity.executeQuery(query);
			data.next();
			cityName = data.getString(Tables.CITIES_COLUMN_CITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityName;
	}

	/**
	 * This method is used to update an city in the database
	 * 
	 * @param city
	 *            an City object to be updated
	 * 
	 */
	public void updateCity(City city) {
		String query = "UPDATE " + Tables.TABLE_CITIES + " SET " + Tables.CITIES_COLUMN_CITY + " = '" + city.getCity()
				+ "'" + " WHERE " + Tables.CITIES_COLUMN_ID + " = " + city.getId();
		try {
			Statement updateMember = db.getConnection().createStatement();
			updateMember.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to delete an city out of the database
	 * 
	 * @param city
	 *            an City object to be deleted
	 * 
	 */
	public void deleteCity(City city) {
		String query = "DELETE FROM " + Tables.TABLE_CITIES + " WHERE " + Tables.CITIES_COLUMN_ID + " = "
				+ city.getId();
		System.out.println("City has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to insert an city in the database
	 * 
	 * @param city
	 *            the City object to be created
	 * 
	 */
	public void createCity(City city) {
		String query = "INSERT INTO " + Tables.TABLE_CITIES + "(" + Tables.CITIES_COLUMN_CITY + ") VALUES ('"
				+ city.getCity() + "');";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("City has been created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
