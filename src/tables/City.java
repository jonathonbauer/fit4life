package tables;

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
	
	public City() {
		
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
