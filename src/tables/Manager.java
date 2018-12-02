package tables;

/**
 * 
 * This class represents a Manager object from within the database. <br/>
 * It contains the ID, first name, last name, address, postal code and the city of the manager.
 * 
 */
public class Manager {

	private int id;
	private String fname;
	private String lname;
	private String address;
	private String postalCode;
	private City city;

	// Constructors
	public Manager(int id, String fname, String lname, String address, String postalCode, City city) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;

	}

	public Manager(String fname, String lname, String address, String postalCode, City city) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;

	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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