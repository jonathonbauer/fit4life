package tabs;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;

public class ManagersTab extends TabTemplate {
	public static ManagersTab instance = null;
	
	private TabPane tabPane;
	private BorderPane root;
	
	private ManagersTab() {
		this.setText("Managers");
		// Declare the inner tab pane and prevent the tabs from being closed
		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		// If there is a session logged in, then display the CRUD tabs for the users
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewManagerTab.getInstance());
//			this.tabPane.getTabs().add(CreateManagerTab.getInstance());	
//			this.tabPane.getTabs().add(ReportManagerTab.getInstance());
		}
		
		// Declare the borderpane and set the inner tabPane to its center
		this.root = new BorderPane();
		this.root.setCenter(this.tabPane);
		
		// Set the content of the tab to the borderpane
		this.setContent(root);
		
	}
	
	
	public static ManagersTab getInstance() {
		if(instance == null) {
			instance = new ManagersTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}
