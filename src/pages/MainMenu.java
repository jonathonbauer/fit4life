package pages;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import tabs.AmenitiesTab;
import tabs.CitiesTab;
import tabs.LocationsTab;
import tabs.ManagersTab;
import tabs.MembersTab;
import tabs.UsersTab;

/**
 * 
 * The Main Menu
 * 
 *
 */
public class MainMenu {


	private Scene scene;
	private TabPane tabPane;
	private menuBar menuBar;
	private BorderPane root;

	public MainMenu() {	

		// TODO: Replace this with the MenuBar that is to be created
		this.menuBar =  new menuBar();

		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		this.root = new BorderPane();

		this.tabPane.getTabs().add(MembersTab.getInstance());
		this.tabPane.getTabs().add(ManagersTab.getInstance());
		this.tabPane.getTabs().add(LocationsTab.getInstance());
		this.tabPane.getTabs().add(CitiesTab.getInstance());
		this.tabPane.getTabs().add(AmenitiesTab.getInstance());
		this.tabPane.getTabs().add(UsersTab.getInstance());
		

		this.root.setTop(this.menuBar);
		this.root.setCenter(this.tabPane);
		
		this.scene = new Scene(this.root, 1024, 768);


	}


	public Scene getScene() {
		return scene;
	}


	public void setScene(Scene scene) {
		this.scene = scene;
	}



	//	public static void main(String[] args) {
	//		// TODO Auto-generated method stub
	//
	//	}



}
