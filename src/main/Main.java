package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
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

	public static Stage popUp;
	
	public LogInMenu logInMenu;
	public Initialization init;
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static void logoAnimate(ImageView logoIV) {
		FadeTransition logoFadeIn = new FadeTransition(Duration.millis(1000), logoIV);
		logoFadeIn.setFromValue(0.5);
		logoFadeIn.setToValue(1);
		logoFadeIn.setCycleCount(1);

		FadeTransition logoFadeOut = new FadeTransition(Duration.millis(1000), logoIV);
		logoFadeOut.setFromValue(1);
		logoFadeOut.setToValue(0.5);
		logoFadeOut.setCycleCount(1);
		
		ScaleTransition logoScaleUp =	new ScaleTransition(Duration.millis(1000), logoIV);
		logoScaleUp.setByX(.03);
		logoScaleUp.setByY(.03);
		
		ScaleTransition logoScaleDown =	new ScaleTransition(Duration.millis(1000), logoIV);
		logoScaleDown.setToX(1);
		logoScaleDown.setToY(1);
		
		SequentialTransition animationScale = new SequentialTransition();
		animationScale.getChildren().addAll(logoScaleUp, logoScaleDown);
		animationScale.setCycleCount(Timeline.INDEFINITE);
		
		
		SequentialTransition animationFade = new SequentialTransition();
		animationFade.getChildren().addAll(logoFadeOut, logoFadeIn);
		animationFade.setCycleCount(Timeline.INDEFINITE);
		animationFade.play();
		
		animationFade.play();
		animationScale.play();
		
	}

	public void start(Stage mainStage) throws Exception {
		Main.mainStage = mainStage;
		Main.popUp = new Stage();
		
		
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
            	System.out.println("Application starting.");
            	        	
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
