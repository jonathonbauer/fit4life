package pages;

import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import main.Session;
import tabs.ViewMemberTab;

public class Members {
	private Scene scene;
	private TabPane tabPane;
	private menuBar menuBar;
	private BorderPane root;

	public Members() {	

		
		this.menuBar =  new menuBar();

		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.tabPane.setSide(Side.LEFT);
		
		this.root = new BorderPane();
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
			
		}

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
}
