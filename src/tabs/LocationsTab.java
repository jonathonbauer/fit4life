package tabs;

public class LocationsTab extends TabTemplate {
	public static LocationsTab instance = null;
	
	private LocationsTab() {
		this.setText("Locations");
		
		this.getCreateButton().setText("Create A New Location");
		this.getUpdateButton().setText("Update a Location");
		this.getViewButton().setText("View Locations");
		this.getReportsButton().setText("Location Reports");
		
	}
	
	public static LocationsTab getInstance() {
		if(instance == null) {
			instance = new LocationsTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}