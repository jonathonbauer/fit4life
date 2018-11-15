package tabs;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;

public class MembersTab extends Tab{
	public static MembersTab instance = null;
	
	private TabPane tabPane;
	private BorderPane root;
	
	private MembersTab() {
		this.setText("Members");
		

		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
			this.tabPane.getTabs().add(UpdateMemberTab.getInstance());
			this.tabPane.getTabs().add(CreateMemberTab.getInstance());				
		}
		
		
		this.root = new BorderPane();
		this.root.setCenter(this.tabPane);
		
		this.setContent(root);
		
	}
	
	
	
	
	
	public static MembersTab getInstance() {
		if(instance == null) {
			instance = new MembersTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}