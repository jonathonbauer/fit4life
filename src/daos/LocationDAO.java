package daos;

import java.util.ArrayList;

import tables.Location;

public interface LocationDAO {

	public ArrayList<Location> getAllLocations();
	public Location getLocation(int locationID);
	public void updateLocation(Location location);
	public void deleteLocation(Location location);
	public void createLocation(Location location);
}
