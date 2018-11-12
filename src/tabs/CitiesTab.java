package tabs;

public class CitiesTab extends TabTemplate {
	public static CitiesTab instance = null;
	
	private CitiesTab() {
		this.setText("Cities");
		
		this.getCreateButton().setText("Create A New City");
		this.getUpdateButton().setText("Update a City");
		this.getViewButton().setText("View Cities");
		this.getReportsButton().setText("City Reports");
		
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