import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogInMenu extends Application {
    public static void main(String[] args){

    	Application.launch();
    }

	
	public void start(Stage primaryStage) throws Exception {
		
		/*
		 * This section of the code is what will run after the program has launched and has no existing profiles logged in.
		 * it will prompt the user for their user name and password and attempt to log them into the database.
		 */ 
			
		
		//BorderPane initialization
		BorderPane pane = new BorderPane();
		
		//Creating VBox's for positioning TextFields
		VBox top = new VBox();
		top.setAlignment(Pos.CENTER);
		
		VBox bottom = new VBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox middle = new VBox();
		middle.setAlignment(Pos.CENTER);
		
		VBox baseline = new VBox();
		baseline.setAlignment(Pos.BASELINE_CENTER);
		
		//Adding in a new font
		Font titleFont = Font.font("Century Gothic", FontWeight.BOLD, FontPosture.REGULAR, 40);
		
		//Adding in Text Nodes
		Text title = new Text("Fit4Life");
		title.setFont(titleFont);
		
		Text errorText = new Text();
		
		
		//Adding in Button Nodes
		
		Button login = new Button("Log In");
		
		//Adding in CheckBox Nodes
		CheckBox remember = new CheckBox("Remember me?");
		
		//Setting default checkbox values
		remember.setIndeterminate(false);
		
		//Adding in TextField and PasswordField to store username and password
		
		TextField userName = new TextField();
		userName.setMaxHeight(30);
		userName.setMinHeight(30);
		userName.setMaxWidth(300);
		userName.setPromptText("USERNAME");
		
		PasswordField passWord = new PasswordField();
		passWord.setMinHeight(30);
		passWord.setMaxHeight(30);
		passWord.setMaxWidth(300);
		passWord.setPromptText("PASSWORD");
		
		
		/*
		 * login Button Event Handler
		 * 
		 */
		
		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				//Code for Log In Button goes here
			}
			
		});
		
		
		
		
		
		/*
		 * Adding the userName and passWord TextArea fields to the "Middle" VBox
		 */
		
		top.getChildren().add(title);
		
		middle.getChildren().addAll(userName, passWord,remember, errorText);
		
		bottom.getChildren().add(login);
		
		pane.setTop(top);
		pane.setBottom(bottom);		
		pane.setCenter(middle);

		Scene logInScene = new Scene(pane, 1024, 768);
		primaryStage.setScene(logInScene);
		primaryStage.setTitle("Fit4Life Login");
		primaryStage.show();
		
	}

}

    	