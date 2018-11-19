package daos;

import java.util.ArrayList;

import tables.Amenity;


public interface AmenityDAO {
	public ArrayList<Amenity> getAllAmenities();
	public Amenity getAmenity(int amenityID);
	public void updateAmenity(Amenity amenity);
	public void deleteAmenity(Amenity amenity);
	public void createAmenity(Amenity amenity);

}
