package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pages.MainMenu;

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
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage mainStage) throws Exception {
		Main.mainStage = mainStage;
		mainMenu = new MainMenu();
		
		// TODO: Check if the user has launched the application before and display the appropriate scene
		Main.mainStage.setScene(mainMenu.getScene());
		Main.mainStage.setTitle("Fit4Life Member Management");
		Main.mainStage.setResizable(false);
		Main.mainStage.show();
		
	}
	
}
