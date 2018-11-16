package tabs;

public class LocationsTab extends TabTemplate {
	public static LocationsTab instance = null;
	
	private LocationsTab() {
		this.setText("Locations");

		
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