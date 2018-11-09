package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import pages.Initialization;
import pages.LogInMenu;
import pages.MainMenu;

/**
 * This is the main method that will launch the application.
 * It contains the mainStage that will be used to host the scenes for each page of the application.
 * 
 */


public class Main extends Application {

	// Main Stage to be used globally
	public static Stage mainStage;
	public MainMenu mainMenu;
	public LogInMenu logInMenu;
	public Initialization init;
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage mainStage) throws Exception {
		Main.mainStage = mainStage;
		mainMenu = new MainMenu();
		logInMenu = new LogInMenu();
		init = new Initialization();
		
		
		// Test if the user has launched the application before, and launch the appropriate page
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/main/hasLaunched.txt"));
			// If the file has no content, the application has never been launched
            if(in.readLine() == null) {
            	System.out.println("First time launch!");  
            	Main.mainStage.setScene(init.getScene());
            } else {
            	System.out.println("We've been here before");
            	        	
            	Main.mainStage.setScene(logInMenu.getScene());
            }
            in.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

		Main.mainStage.setTitle("Fit4Life Login");
		Main.mainStage.setResizable(false);
		Main.mainStage.show();
		
	}
	
}
