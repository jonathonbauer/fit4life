package daos;

import java.util.ArrayList;

import tables.Amenity;

/**
 * 
 * This data access object is used to tell the AmenityTable object what
 * functionality it needs to provide.
 * 
 *
 */
public interface AmenityDAO {
	public ArrayList<Amenity> getAllAmenities();

	public Amenity getAmenity(int amenityID);

	public void updateAmenity(Amenity amenity);

	public void deleteAmenity(Amenity amenity);

	public void createAmenity(Amenity amenity);

}
