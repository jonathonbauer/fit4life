package tabs;

import javafx.geometry.Pos;
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
	private Tab view;
	private Tab update;
	private Tab create;
	
	private VBox buttonBox;
	private BorderPane root;
	
	// Constructor
	public TabTemplate() {
		this.setText("Members");

//		this.currentUser = new Text("Current User: " + Session.getInstance().getLoggedInUser().getUsername());

		this.tabPane = new TabPane();
		this.tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		this.view = new Tab("View");
		this.update = new Tab("Update");
		this.create = new Tab("Create");
		
		
		if(Session.isLoggedIn()) {
			this.tabPane.getTabs().add(this.view);
			this.tabPane.getTabs().add(this.update);
			this.tabPane.getTabs().add(this.create);			
			
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
	
	
	public Tab getView() {
		return view;
	}

	public void setView(Tab view) {
		this.view = view;
	}

	public Tab getUpdate() {
		return update;
	}

	public void setUpdate(Tab update) {
		this.update = update;
	}

	public Tab getCreate() {
		return create;
	}

	public void setCreate(Tab create) {
		this.create = create;
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
