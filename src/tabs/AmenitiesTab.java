package tabs;

public class AmenitiesTab extends TabTemplate {
	public static AmenitiesTab instance = null;
	
	private AmenitiesTab() {
		this.setText("Amenities");
		
		this.getCreateButton().setText("Create A New Amenity");
		this.getUpdateButton().setText("Update an Amenity");
		this.getViewButton().setText("View Amenities");
		this.getReportsButton().setText("Amenity Reports");
		
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