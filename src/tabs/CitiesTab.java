package tabs;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;

public class CitiesTab extends TabTemplate {
	public static CitiesTab instance = null;
	
	private TabPane tabPane;
	private BorderPane root;
	
	private CitiesTab() {
		this.setText("Cities");
		// Declare the inner tab pane and prevent the tabs from being closed
		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		// If there is a session logged in, then display the CRUD tabs for the users
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewCities.getInstance());
			this.tabPane.getTabs().add(CreateCitiesTab.getInstance());	
			this.tabPane.getTabs().add(ReportCitiesTab.getInstance());
		}
		
		// Declare the borderpane and set the inner tabPane to its center
		this.root = new BorderPane();
		this.root.setCenter(this.tabPane);
		
		// Set the content of the tab to the borderpane
		this.setContent(root);
		
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