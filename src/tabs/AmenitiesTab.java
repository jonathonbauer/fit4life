package tabs;

public class AmenitiesTab extends TabTemplate {
	public static AmenitiesTab instance = null;
	
	private AmenitiesTab() {
		this.setText("Amenities");

		
	}
	
	public static AmenitiesTab getInstance() {
		if(instance == null) {
			instance = new AmenitiesTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}