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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Main;
import tables.User;

public class Initialization {
	private Text dbInfo;
	private Text userInfo;
	
	private TextField dbNameField;
	private TextField dbHostField;
	private TextField dbUserField;
	private PasswordField dbPassField;
	private TextField userField;
	private PasswordField passwordField;
	private PasswordField verifyPasswordField;
	private Button submitButton;
	
	private VBox centerBox;
	private VBox dbBox;
	private VBox userBox;
	private menuBar menuBar;
	private BorderPane root;
	private Scene scene;
	
	public Initialization() {
		this.dbInfo = new Text("Database Information");
		this.dbInfo.setFont(Font.font("Century Gothic", FontWeight.BOLD, FontPosture.REGULAR, 25));
		this.userInfo = new Text("User Information");
		this.userInfo.setFont(Font.font("Century Gothic", FontWeight.BOLD, FontPosture.REGULAR, 25));
		
		
		this.dbNameField = new TextField();
		this.dbNameField.setPromptText("fit4life");
		this.dbHostField = new TextField();
		this.dbHostField.setPromptText("localhost");
		this.dbUserField = new TextField();
		this.dbUserField.setPromptText("admin");
		this.dbPassField = new PasswordField();
		this.dbPassField.setPromptText("password");
		
		this.userField = new TextField();
		this.userField.setPromptText("admin");
		this.passwordField = new PasswordField();
		this.passwordField.setPromptText("password");
		this.verifyPasswordField = new PasswordField();
		this.verifyPasswordField.setPromptText("password");
		
		this.dbNameField.setMaxWidth(150);
		this.dbHostField.setMaxWidth(150);
		this.dbUserField.setMaxWidth(150);
		this.dbPassField.setMaxWidth(150);
		
		this.userField.setMaxWidth(150);
		this.passwordField.setMaxWidth(150);
		this.verifyPasswordField.setMaxWidth(150);
		
		this.submitButton = new Button("Submit");
		
		// TODO: Button handlers with form validation
		
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
            	
				UserTable userTable = new UserTable();
				userTable.createUser(new User(this.userField.getText(), this.passwordField.getText()));
				LogInMenu loginMenu = new LogInMenu();
				Main.mainStage.setScene(loginMenu.getScene());
			}
		});
		
		
		// TODO: Replace this with the MenuBar that is to be created
		this.menuBar = new menuBar();
		
		this.dbBox = new VBox();
		this.dbBox.getChildren().addAll(this.dbInfo, this.dbHostField, this.dbNameField, this.dbUserField, this.dbPassField);
		this.dbBox.setSpacing(5);
		this.dbBox.setAlignment(Pos.CENTER);
		
		this.userBox = new VBox();
		this.userBox.getChildren().addAll(this.userInfo, this.userField, this.passwordField, this.verifyPasswordField);
		this.userBox.setSpacing(5);
		this.userBox.setAlignment(Pos.CENTER);
		
		this.centerBox = new VBox();
		this.centerBox.getChildren().addAll(this.dbBox, this.userBox, this.submitButton);
		this.centerBox.setSpacing(25);
		this.centerBox.setAlignment(Pos.CENTER);
		
		this.root = new BorderPane();
		this.root.setTop(this.menuBar);
		this.root.setCenter(this.centerBox);
		
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
