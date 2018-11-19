package pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import database.Database;
import javabeans.UserTable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Main;
import tables.User;

public class Initialization {
	
	// Headers
	private Text dbInfo;
	private Text userInfo;
	
	// Database Information
	private Text dbName;
	private TextField dbNameField;
	private Text dbHost;
	private TextField dbHostField;
	
	private Text dbUser;
	private TextField dbUserField;
	
	private Text dbPass;
	private PasswordField dbPassField;
	
	// User Information
	private Text user;
	private TextField userField;
	
	private Text password;
	private PasswordField passwordField;
	
	private Text verifyPassword;
	private PasswordField verifyPasswordField;
	private Button submitButton;
	
	// Layout Nodes
	private HBox dbHostBox;
	private HBox dbNameBox;
	private HBox dbUserBox;
	private HBox dbPassBox;
	private HBox userBox;
	private HBox passBox;
	private HBox verifyPassBox;
	
	
	private VBox centerBox;
	private VBox dbInfoBox;
	private VBox userInfoBox;
	private menuBar menuBar;
	private BorderPane root;
	private Scene scene;
	
	public Initialization() {
		// Headers
		this.dbInfo = new Text("Database Information");
		this.dbInfo.setFont(Font.font("Century Gothic", FontWeight.BOLD, FontPosture.REGULAR, 25));
		this.userInfo = new Text("User Information");
		this.userInfo.setFont(Font.font("Century Gothic", FontWeight.BOLD, FontPosture.REGULAR, 25));
		
		
		// Database Information
		this.dbHost = new Text("Database Host");
		this.dbHostField = new TextField();
		this.dbHostField.setPromptText("localhost");
		
		this.dbName = new Text("Database Name");
		this.dbNameField = new TextField();
		this.dbNameField.setPromptText("fit4life");
		
		
		// User Information
		this.dbUser = new Text("Database Username");
		this.dbUserField = new TextField();
		this.dbUserField.setPromptText("admin");
		
		this.dbPass = new Text("Database Password");
		this.dbPassField = new PasswordField();
		this.dbPassField.setPromptText("password");
		
		this.user = new Text("Create Username");
		this.userField = new TextField();
		this.userField.setPromptText("admin");
		
		this.password = new Text("Create Password");
		this.passwordField = new PasswordField();
		this.passwordField.setPromptText("password");
		
		this.verifyPassword = new Text("Verify Password");
		this.verifyPasswordField = new PasswordField();
		this.verifyPasswordField.setPromptText("password");
		
		// Style the TextFields
		
		this.dbNameField.setMaxWidth(250);
		this.dbHostField.setMaxWidth(250);
		this.dbUserField.setMaxWidth(250);
		this.dbPassField.setMaxWidth(250);
		
		this.userField.setMaxWidth(250);
		this.passwordField.setMaxWidth(250);
		this.verifyPasswordField.setMaxWidth(250);
		
		// Submit Button
		this.submitButton = new Button("Submit");
		
		this.submitButton.setOnAction(e->{
			Boolean flag = true;
			
			// Check that all fields are populated and have valid info
			if(this.dbNameField.getText().isEmpty()) {
				System.out.println("Database Name not entered");
				flag = false;
			}
			if(this.dbHostField.getText().isEmpty()) {
				System.out.println("Database Host not entered");
				flag = false;
			}
			if(this.dbUserField.getText().isEmpty()) {
				System.out.println("Database User not entered");
				flag = false;
			}
			if(this.dbPassField.getText().isEmpty()) {
				System.out.println("Database Password not entered");
				flag = false;
			}
			if(this.userField.getText().isEmpty()) {
				System.out.println("Username not entered");
				flag = false;
			}
			if(this.passwordField.getText().isEmpty() || this.verifyPasswordField.getText().isEmpty() || !this.passwordField.getText().equals(this.verifyPasswordField.getText())) {
				System.out.println("Passwords do not match");
				flag = false;
			}
			
			// Set the constants in the config to the Database from the text views
			
			// Initialize the database
			Database db = Database.getInstance();
			
			// Test the connection to the database
			if(!db.testConnection()) {
				System.out.println("Connection could not be established");
				flag = false;
			}
		
			// If input passes validation, change the first time launch flag,
			// create the user in the database and set the scene to the login page
			if(flag) {
				BufferedWriter out;
				try {
					out = new BufferedWriter(new FileWriter("src/main/hasLaunched.txt"));
					out.write("true");
	            	out.flush();
	            	out.close();  
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				db.createTables();
				UserTable userTable = new UserTable();
				userTable.createUser(new User(this.userField.getText(), this.passwordField.getText()));
				LogInMenu loginMenu = new LogInMenu();
				Main.mainStage.setScene(loginMenu.getScene());
			}
		});
		
		
		
		this.menuBar = new menuBar();
		
		// Add the Text & Fields to the HBoxs, add Spacing and align them to center
		
		this.dbHostBox = new HBox();
		this.dbHostBox.getChildren().addAll(this.dbHost, this.dbHostField);
		this.dbHostBox.setSpacing(10);
		this.dbHostBox.setAlignment(Pos.CENTER);
		
		this.dbNameBox = new HBox();
		this.dbNameBox.getChildren().addAll(this.dbName, this.dbNameField);
		this.dbNameBox.setSpacing(10);
		this.dbNameBox.setAlignment(Pos.CENTER);
		
		this.dbUserBox = new HBox();
		this.dbUserBox.getChildren().addAll(this.dbUser, this.dbUserField);
		this.dbUserBox.setSpacing(10);
		this.dbUserBox.setAlignment(Pos.CENTER);
		
		this.dbPassBox = new HBox();
		this.dbPassBox.getChildren().addAll(this.dbPass, this.dbPassField);
		this.dbPassBox.setSpacing(10);
		this.dbPassBox.setAlignment(Pos.CENTER);
		
		this.userBox = new HBox();
		this.userBox.getChildren().addAll(this.user, this.userField);
		this.userBox.setSpacing(10);
		this.userBox.setAlignment(Pos.CENTER);
		
		this.passBox = new HBox();
		this.passBox.getChildren().addAll(this.password, this.passwordField);
		this.passBox.setSpacing(10);
		this.passBox.setAlignment(Pos.CENTER);
		
		this.verifyPassBox = new HBox();
		this.verifyPassBox.getChildren().addAll(this.verifyPassword, this.verifyPasswordField);
		this.verifyPassBox.setSpacing(10);
		this.verifyPassBox.setAlignment(Pos.CENTER);
		
		// Add the Hboxs to the VBoxs, add spacing, and align them to the center
		
		this.dbInfoBox = new VBox();
		this.dbInfoBox.getChildren().addAll(this.dbInfo, this.dbHostBox, this.dbNameBox, this.dbUserBox, this.dbPassBox);
		this.dbInfoBox.setSpacing(10);
		this.dbInfoBox.setAlignment(Pos.CENTER);
		
		this.userInfoBox = new VBox();
		this.userInfoBox.getChildren().addAll(this.userInfo, this.userBox, this.passBox, this.verifyPassBox);
		this.userInfoBox.setSpacing(10);
		this.userInfoBox.setAlignment(Pos.CENTER);
		
		this.centerBox = new VBox();
		this.centerBox.getChildren().addAll(this.dbInfoBox, this.userInfoBox, this.submitButton);
		this.centerBox.setSpacing(25);
		this.centerBox.setAlignment(Pos.CENTER);
		
		// Create the BorderPane and add the nodes to it
		this.root = new BorderPane();
		this.root.setTop(this.menuBar);
		this.root.setCenter(this.centerBox);
		
		// Set the BorderPane to the scene
		this.scene = new Scene(this.root, 1024, 768);
		
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

	public void setDbPassField(PasswordField dbPassField) {
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

	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public TextField getVerifyPasswordField() {
		return verifyPasswordField;
	}

	public void setVerifyPasswordField(PasswordField verifyPasswordField) {
		this.verifyPasswordField = verifyPasswordField;
	}

	public Button getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(Button submitButton) {
		this.submitButton = submitButton;
	}

	public VBox getDbInfoBox() {
		return dbInfoBox;
	}

	public void setDbInfoBox(VBox dbInfoBox) {
		this.dbInfoBox = dbInfoBox;
	}

	public VBox getUserInfoBox() {
		return userInfoBox;
	}

	public void setUserInfoBox(VBox userInfoBox) {
		this.userInfoBox = userInfoBox;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(menuBar menuBar) {
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
