package tabs;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.Session;
import pages.Reports;

public class TabTemplate extends Tab{
	public static TabTemplate instance = null;
	
	private Text currentUser;
	public Reports reportMenu;
	private Button createButton;
	private Button updateButton;
	private Button viewButton;
	private Button reportsButton;
	private TabPane tabPane;
	
	private VBox buttonBox;
	private BorderPane root;
	
	// Constructor
	public TabTemplate() {
		this.setText("Members");
		
		this.createButton = new Button("Create");
		this.updateButton = new Button("Update");
		this.viewButton = new Button("View");
		this.reportsButton = new Button("Reports");

		this.createButton.setMinSize(750, 100);
		this.updateButton.setMinSize(750, 100);
		this.viewButton.setMinSize(750, 100);
		this.reportsButton.setMinSize(750, 100);
		
		this.currentUser = new Text("Current User: " + Session.getInstance().getLoggedInUser().getUsername());
		
		this.buttonBox = new VBox();
		this.buttonBox.getChildren().addAll(createButton, updateButton, viewButton, reportsButton, this.currentUser);
		this.buttonBox.setSpacing(5);
		this.buttonBox.setAlignment(Pos.CENTER);
		
		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
//		this.tabPane.setSide(Side.LEFT);
		
		
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
//			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
//			this.tabPane.getTabs().add(ViewMemberTab.getInstance());
			
		}
		
		
		this.root = new BorderPane();
		this.root.setCenter(this.tabPane);
		
		this.setContent(root);
		
	}

	// getInstance Method
	
	public Button getCreateButton() {
		return createButton;
	}

	public void setCreateButton(Button createButton) {
		this.createButton = createButton;
	}

	public Button getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(Button updateButton) {
		this.updateButton = updateButton;
	}

	public Button getViewButton() {
		return viewButton;
	}

	public void setViewButton(Button viewButton) {
		this.viewButton = viewButton;
	}

	public Button getReportsButton() {
		return reportsButton;
	}

	public void setReportsButton(Button reportsButton) {
		this.reportsButton = reportsButton;
	}

	public VBox getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(VBox buttonBox) {
		this.buttonBox = buttonBox;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public static TabTemplate getInstance() {
		if(instance == null) {
			instance = new TabTemplate();
			return instance;
		} else {
			return instance;
		}
		
	}


}
