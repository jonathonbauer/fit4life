package tabs;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;

/**
 * 
 *  This class is used to display all CRUD tabs for the User Database
 *  This class follows the Singleton design pattern
 *
 */
public class UsersTab extends Tab {
	public static UsersTab instance = null;
	
	private TabPane tabPane;
	private BorderPane root;
	
	private UsersTab() {
		// Set the title of the tab
		this.setText("Users");

		// Declare the inner tab pane and prevent the tabs from being closed
		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		// If there is a session logged in, then display the CRUD tabs for the users
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewUserTab.getInstance());		
		}
		
		// Declare the borderpane and set the inner tabPane to its center
		this.root = new BorderPane();
		this.root.setCenter(this.tabPane);
		
		// Set the content of the tab to the borderpane
		this.setContent(root);
	}
	
	// getInstance method used to get the existing UsersTab or create one if it doesn't yet exist
	public static UsersTab getInstance() {
		if(instance == null) {
			instance = new UsersTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}