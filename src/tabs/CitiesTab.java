package tabs;

public class CitiesTab extends TabTemplate {
	public static CitiesTab instance = null;
	
	private CitiesTab() {
		this.setText("Cities");

		
	}
	
	public static CitiesTab getInstance() {
		if(instance == null) {
			instance = new CitiesTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}