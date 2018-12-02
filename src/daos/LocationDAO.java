package daos;

import java.util.ArrayList;

import tables.Location;

/**
 * 
 * This data access object is used to tell the LocationTable object what
 * functionality it needs to provide.
 * 
 *
 */
public interface LocationDAO {

	public ArrayList<Location> getAllLocations();

	public Location getLocation(int locationID);

	public void updateLocation(Location location);

	public void deleteLocation(Location location);

	public void createLocation(Location location);
}
