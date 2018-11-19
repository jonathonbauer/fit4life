package tables;
public class Manager {

	
		private int id;
		private String name;
		private String address;
		private String postalCode;
//		TODO: Change to appropriate classes
		private String city;

		
		// Constructors
		public Manager(int id, String name, String address, String postalCode, String city) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.postalCode = postalCode;
			this.city = city;
			
		}

		public Manager(String name, String address, String postalCode, String city) {
			super();
			this.name = name;
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

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		
		
		
		
		
		
	}