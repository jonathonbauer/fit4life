package tabs;

import database.Database;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class ViewUserTab extends Tab {
	Database db = Database.getInstance();


	public static ViewUserTab instance = null;
	private Button refresh;

	private BorderPane root;


	public ViewUserTab() {

		this.setText("View Users");


		this.refresh = new Button("Refresh");


		this.root = new BorderPane();
		this.root.setBottom(this.refresh);

		this.setContent(root);
	}

	public static ViewUserTab getInstance() {
		if(instance == null) {
			instance = new ViewUserTab();
			return instance;
		} else {
			return instance;
		}

	}

}
