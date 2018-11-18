package daos;

import java.util.ArrayList;

import tables.Amenity;


public interface AmenityDAO {
	public ArrayList<Amenity> getAllMembers();
	public Amenity getMember(int amenityID);
	public void updateMember(Amenity amenity);
	public void deleteMember(Amenity amenity);
	public void createMember(Amenity amenity);

}
