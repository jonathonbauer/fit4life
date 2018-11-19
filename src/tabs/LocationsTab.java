package tabs;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;

public class LocationsTab extends TabTemplate {
	public static LocationsTab instance = null;
	
	private TabPane tabPane;
	private BorderPane root;
	
	private LocationsTab() {
		
	this.setText("Locations");

	//Declare TabPane & Make sure tabs cannot be closed
	this.tabPane = new TabPane();
	this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
			
	//If logged in, display Create, Update, View tabs
	if(Session.isLoggedIn()) {
		this.tabPane.getTabs().add(ViewLocationTab.getInstance());
		this.tabPane.getTabs().add(CreateLocationTab.getInstance());
		this.tabPane.getTabs().add(UpdateLocationTab.getInstance());
		}
	
	this.root = new BorderPane();
	this.root.setCenter(this.tabPane);
			
	this.setContent(root);
			
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