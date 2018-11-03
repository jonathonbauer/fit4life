package pages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.Config;

public class Initialization {
	private TextField dbNameField;
	private TextField dbHostField;
	private TextField dbUserField;
	private TextField dbPassField;
	private TextField userField;
	private TextField passwordField;
	private TextField verifyPasswordField;
	private Button submitButton;
	
	private VBox centerBox;
	private VBox dbBox;
	private VBox userBox;
	private MenuBar menuBar;
	private BorderPane root;
	private Scene scene;
	
	public Initialization() {
		this.dbNameField = new TextField("Database Name");
		this.dbHostField = new TextField("Database Host");
		this.dbUserField = new TextField("Database User");
		this.dbPassField = new TextField("Database Pass");
		
		this.userField = new TextField("Create User Name");
		this.passwordField = new TextField("Create Password");
		this.verifyPasswordField = new TextField("Verify Password");
		
		this.dbNameField.setMaxWidth(150);
		this.dbHostField.setMaxWidth(150);
		this.dbUserField.setMaxWidth(150);
		this.dbPassField.setMaxWidth(150);
		
		this.userField.setMaxWidth(150);
		this.passwordField.setMaxWidth(150);
		this.verifyPasswordField.setMaxWidth(150);
		
		this.submitButton = new Button("Submit");
		
		// TODO: Button handlers with form validation
		
		
		
		
		// TODO: Replace this with the MenuBar that is to be created
		this.menuBar = new MenuBar();
		
		this.dbBox = new VBox();
		this.dbBox.getChildren().addAll(this.dbHostField, this.dbNameField, this.dbUserField, this.dbPassField);
		this.dbBox.setSpacing(5);
		this.dbBox.setAlignment(Pos.CENTER);
		
		this.userBox = new VBox();
		this.userBox.getChildren().addAll(this.userField, this.passwordField, this.verifyPasswordField);
		this.userBox.setSpacing(5);
		this.userBox.setAlignment(Pos.CENTER);
		
		this.centerBox = new VBox();
		this.centerBox.getChildren().addAll(this.dbBox, this.userBox, this.submitButton);
		this.centerBox.setSpacing(25);
		this.centerBox.setAlignment(Pos.CENTER);
		
		this.root = new BorderPane();
		this.root.setTop(this.menuBar);
		this.root.setCenter(this.centerBox);
		
		this.scene = new Scene(this.root, Config.APP_WIDTH, Config.APP_HEIGHT);
		
	}

	// Getters & Setters
	
	public TextField getDbNameField() {
		return dbNameField;
	}

	public void setDbNameField(TextField dbNameField) {
		this.dbNameField = dbNameField;
	}

	public TextField getDbHostField() {
		return dbHostField;
	}

	public void setDbHostField(TextField dbHostField) {
		this.dbHostField = dbHostField;
	}

	public TextField getDbUserField() {
		return dbUserField;
	}

	public void setDbUserField(TextField dbUserField) {
		this.dbUserField = dbUserField;
	}

	public TextField getDbPassField() {
		return dbPassField;
	}

	public void setDbPassField(TextField dbPassField) {
		this.dbPassField = dbPassField;
	}

	public TextField getUserField() {
		return userField;
	}

	public void setUserField(TextField userField) {
		this.userField = userField;
	}

	public TextField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(TextField passwordField) {
		this.passwordField = passwordField;
	}

	public TextField getVerifyPasswordField() {
		return verifyPasswordField;
	}

	public void setVerifyPasswordField(TextField verifyPasswordField) {
		this.verifyPasswordField = verifyPasswordField;
	}

	public Button getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(Button submitButton) {
		this.submitButton = submitButton;
	}

	public VBox getDbBox() {
		return dbBox;
	}

	public void setDbBox(VBox dbBox) {
		this.dbBox = dbBox;
	}

	public VBox getUserBox() {
		return userBox;
	}

	public void setUserBox(VBox userBox) {
		this.userBox = userBox;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
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
	
	
}
