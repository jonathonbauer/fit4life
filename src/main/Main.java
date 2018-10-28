package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	// Main Stage to be used globally
	public static Stage mainStage;
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage mainStage) throws Exception {
		Main.mainStage = mainStage;
		
		// TODO: Check if the user has launched the application before and display the appropriate scene
		Main.mainStage.setScene(new Scene(null));
		Main.mainStage.setTitle("Fit4Life Member Management");
		Main.mainStage.setResizable(false);
		Main.mainStage.show();
		
	}
	
}
