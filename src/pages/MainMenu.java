package pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.Main;

/**
 * 
 * The Main Menu
 * 
 *
 */
public class MainMenu {
	
	public Reports reportMenu;

	private Button createButton;
	private Button updateButton;
	private Button viewButton;
	private Button reportsButton;
	
	private VBox buttonBox;
	private Text currentUser;
	private pages.menuBar menuBar;
	private BorderPane root;
	private Scene scene;
	
	
	public MainMenu() {
		this.createButton = new Button("Create A New Membership");
		this.updateButton = new Button("Update An Existing Membership");
		this.viewButton = new Button("View Memberships");
		this.reportsButton = new Button("Reports");
		
		this.createButton.setMinSize(750, 100);
		this.updateButton.setMinSize(750, 100);
		this.viewButton.setMinSize(750, 100);
		this.reportsButton.setMinSize(750, 100);
		
		
		// TODO: Replace this with the MenuBar that is to be created
		this.menuBar =  new menuBar();
		
		this.buttonBox = new VBox();
		this.buttonBox.getChildren().addAll(createButton, updateButton, viewButton, reportsButton);
		this.buttonBox.setSpacing(5);
		this.buttonBox.setAlignment(Pos.CENTER);
		
		// TODO: Change this to the current logged in user
		this.currentUser = new Text("Logged in as: ");
		
		this.root = new BorderPane();
		this.root.setTop(this.menuBar);
		this.root.setCenter(this.buttonBox);
		this.root.setBottom(this.currentUser);
		BorderPane.setAlignment(this.currentUser, Pos.CENTER);
		
		
		// TODO: Button event handlers
		this.reportsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				reportMenu = new Reports();
				
				Main.mainStage.setScene(reportMenu.getScene());
				Main.mainStage.setTitle("Fit4Life - Reports");
				Main.mainStage.setResizable(false);
				Main.mainStage.show();
			}
			
		});
		

		this.scene = new Scene(this.root, 1024, 768);
		

	}


	public Reports getReportMenu() {
		return reportMenu;
	}


	public void setReportMenu(Reports reportMenu) {
		this.reportMenu = reportMenu;
	}


	public Text getCurrentUser() {
		return currentUser;
	}


	public void setCurrentUser(Text currentUser) {
		this.currentUser = currentUser;
	}


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


	public pages.menuBar getMenuBar() {
		return menuBar;
	}


	public void setMenuBar(pages.menuBar menuBar) {
		this.menuBar = menuBar;
	}


	public BorderPane getRoot() {
		return root;
	}


	public void setRoot(BorderPane root) {
		this.root = root;
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
