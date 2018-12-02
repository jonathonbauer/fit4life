package tables;
/**
 * 
 * This class represents a Location object from within the database. <br/>
 * It contains the ID, the name, the address, the postal code and the city of the location.
 * 
 */
public class Location {
	private int id;
	private String name;
	private String address;
	private String postalCode;
	private City city;
	
	public Location(int id, String name, String address, String postalCode, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public Location(String name, String address, String postalCode, City city) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public Location() {
		
	}
	
	public String toString() {
		return this.name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

}
