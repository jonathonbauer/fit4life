package daos;
import java.util.ArrayList;

import tables.City;

public interface CityDAO {
	public ArrayList<City> getAllCities();
	public City getCity(int cityID);
	public void updateCity(City city);
	public void deleteCity(City city);
	public void createCity(City city);

}
