package tabs;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;

public class AmenitiesTab extends TabTemplate {
	public static AmenitiesTab instance = null;
	
	private TabPane tabPane;
	private BorderPane root;
	
	
	private AmenitiesTab() {
		this.setText("Amenities");

		//Declare TabPane & Make sure tabs cannot be closed
		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//If logged in, display Create, Update, View tabs
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewAmenityTab.getInstance());
			this.tabPane.getTabs().add(CreateAmenityTab.getInstance());
			this.tabPane.getTabs().add(UpdateAmenityTab.getInstance());
//			this.tabPane.getTabs().add(ReportAmenityTab.getInstance());
			}
		
		
		this.root = new BorderPane();
		this.root.setCenter(this.tabPane);
		
		this.setContent(root);
		
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