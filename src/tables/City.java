package tables;


/**
 * 
 * This class represents a City object from within the database. <br/>
 * It contains the ID of the city, and the name of the city.
 * 
 */
public class City {
	private int id;
	private String city;

	
	// Constructors
	public City(int id, String city) {
		super();
		this.id = id;
		this.city = city;
		
	}

	public City(String city) {
		super();
		this.city = city;
	
	}
	//getters and setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString() {
		return this.city;
	}

}
