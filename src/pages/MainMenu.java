package pages;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;
import tabs.AmenitiesTab;
import tabs.CitiesTab;
import tabs.LocationsTab;
import tabs.ManagersTab;
import tabs.MembersTab;

/**
 * 
 * The Main Menu is the page that is displayed after the user is successfully
 * authenticated. <br/>
 * It contains a Scene that hosts a BorderPane, which hosts a MenuBar and a
 * TabPane <br/>
 * It hosts a TabPane that displays all of the tabs within the application, as
 * well as the MenuBar.
 * 
 */
public class MainMenu {

	private Scene scene;
	private TabPane tabPane;
	private menuBar menuBar;
	private BorderPane root;

	public MainMenu() {

		this.menuBar = new menuBar();

		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		this.root = new BorderPane();
		if (Session.isLoggedIn()) {
			this.tabPane.getTabs().add(MembersTab.getInstance());
			this.tabPane.getTabs().add(ManagersTab.getInstance());
			this.tabPane.getTabs().add(LocationsTab.getInstance());
			this.tabPane.getTabs().add(CitiesTab.getInstance());
			this.tabPane.getTabs().add(AmenitiesTab.getInstance());
		}

		this.root.setTop(this.menuBar);
		this.root.setCenter(this.tabPane);

		this.scene = new Scene(this.root, 1024, 768);
		this.scene.getStylesheets().add("style/style.css");
		this.tabPane.getStylesheets().add("style/syle.css");
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
