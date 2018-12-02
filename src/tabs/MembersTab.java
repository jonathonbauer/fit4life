package tabs;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;

/**
 * 
 *  This class is used to display all CRUD and Report tabs for the Member Database
 *
 */
public class MembersTab extends Tab{
	public static MembersTab instance = null;
	
	private TabPane tabPane;
	private BorderPane root;
	
	private MembersTab() {
		// Set the title of the tab
		this.setText("Members");
		
		// Declare the inner tab pane and prevent the tabs from being closed
		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		// If there is a session logged in, then display the CRUD tabs for the users
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
			this.tabPane.getTabs().add(CreateMemberTab.getInstance());	
			//this.tabPane.getTabs().add(MemberRegistrationReport.getInstance());
			//this.tabPane.getTabs().add(MemberLevelReport.getInstance());
		}
		
		// Declare the borderpane and set the inner tabPane to its center
		this.root = new BorderPane();
		this.root.setCenter(this.tabPane);
		
		// Set the content of the tab to the borderpane
		this.setContent(root);
		
	}
	
	
	// getInstance method used to get the existing MembersTab or create one if it doesn't yet exist
	public static MembersTab getInstance() {
		if(instance == null) {
			instance = new MembersTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}