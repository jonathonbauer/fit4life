package daos;

import java.util.ArrayList;

import tables.City;

/**
 * 
 * This data access object is used to tell the CityTable object what
 * functionality it needs to provide.
 * 
 *
 */
public interface CityDAO {
	public ArrayList<City> getAllCities();

	public City getCity(int cityID);

	public void updateCity(City city);

	public void deleteCity(City city);

	public void createCity(City city);

}
