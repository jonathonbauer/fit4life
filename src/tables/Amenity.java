package tables;

public class Amenity {

	private int id;
	private String amenity;
	
	public Amenity(int id, String amenity) {
		super();
		this.id = id;
		this.amenity = amenity;
	}
	public Amenity(String amenity) {
		super();
		this.amenity = amenity;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAmenity() {
		return amenity;
	}
	
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}
}
