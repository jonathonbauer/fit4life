package pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import database.Database;
import javabeans.UserTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
	private Button testButton;
		
	private GridPane dbGP;
	private GridPane userGP;
	
	private VBox dbTextBox;
	private VBox dbFieldBox;
	private VBox userTextBox;
	private VBox userFieldBox;
	private VBox centerBox;
	private HBox dbInfoBox;
	private HBox userInfoBox;
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
					System.out.println("File could not be modified");
					e1.printStackTrace();
				}
				
				db.createTables();
				UserTable userTable = new UserTable();
				userTable.createUser(new User(this.userField.getText(), this.passwordField.getText()));
				LogInMenu loginMenu = new LogInMenu();
				Main.mainStage.setScene(loginMenu.getScene());
			}
		});
		
		this.testButton = new Button("Test Connection");
		
		
		this.menuBar = new menuBar();
		
		// Add the Text & Fields to the HBoxs, add Spacing and align them to center
		
		this.dbGP = new GridPane();
		this.dbGP.setAlignment(Pos.CENTER);
		this.dbGP.setHgap(25);
		this.dbGP.setVgap(10);
		
		this.dbGP.add(this.dbHost, 0, 0);
		this.dbGP.add(this.dbHostField, 1, 0);
		
		this.dbGP.add(this.dbName, 0, 1);
		this.dbGP.add(this.dbNameField, 1, 1);
		
		this.dbGP.add(this.dbUser, 0, 2);
		this.dbGP.add(this.dbUserField, 1, 2);
		
		this.dbGP.add(this.dbPass, 0, 3);
		this.dbGP.add(this.dbPassField, 1, 3);
		
		this.userGP = new GridPane();
		this.userGP.setAlignment(Pos.CENTER);
		this.userGP.setHgap(25);
		this.userGP.setVgap(10);
		
		this.userGP.add(this.user, 0, 0);
		this.userGP.add(this.userField, 1, 0);
		
		this.userGP.add(this.password, 0, 1);
		this.userGP.add(this.passwordField, 1, 1);
		
		this.userGP.add(this.verifyPassword, 0, 2);
		this.userGP.add(this.verifyPasswordField, 1, 2);
						
		// Add the Hboxs to the VBoxs, add spacing, and align them to the center
		
//		this.dbInfoBox = new HBox();
//		this.dbInfoBox.getChildren().addAll(this.dbTextBox, this.dbFieldBox);
//		this.dbInfoBox.setSpacing(10);
//		this.dbInfoBox.setAlignment(Pos.CENTER);
//		
//		this.userInfoBox = new HBox();
//		this.userInfoBox.getChildren().addAll(this.userTextBox, this.userFieldBox);
//		this.userInfoBox.setSpacing(10);
//		this.userInfoBox.setAlignment(Pos.CENTER);
		
		this.centerBox = new VBox();
		this.centerBox.getChildren().addAll(this.dbInfo, this.dbGP, this.testButton, this.userInfo,  this.userGP, this.submitButton);
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
