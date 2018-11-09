package main;

import database.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import pages.MainMenu;
import pages.LogInMenu;

/**
 * This is the main method that will launch the application.
 * It contains the mainStage that will be used to host the scenes for each page of the application.
 * 
 *
 */


public class Main extends Application {

	// Main Stage to be used globally
	public static Stage mainStage;
	public MainMenu mainMenu;
	public LogInMenu logInMenu;
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage mainStage) throws Exception {
		Main.mainStage = mainStage;
		mainMenu = new MainMenu();
		logInMenu = new LogInMenu();
		Database db = Database.getInstance();
		
		
		// TODO: Check if the user has launched the application before and display the appropriate scene
		Main.mainStage.setScene(logInMenu.getScene());
		Main.mainStage.setTitle("Fit4Life Login");
		Main.mainStage.setResizable(false);
		Main.mainStage.show();
		
	}
	
}
