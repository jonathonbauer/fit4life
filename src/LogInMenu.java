import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
		
		
		
		
		//Adding in TextArea's for both the username and password fields
		
		TextArea userName = new TextArea();
		userName.setMaxHeight(10);
		userName.setMaxWidth(500);
		userName.setText("USERNAME");
		
		TextArea passWord = new TextArea();
		passWord.setMaxHeight(10);
		passWord.setMaxWidth(500);
		passWord.setText("PASSWORD");
		
		/*
		 * Adding the userName and passWord TextArea fields to the "Middle" VBox
		 */
		
		top.getChildren().add(title);
		
		middle.getChildren().addAll(userName, passWord);
		
		
		pane.setTop(top);
		pane.setBottom(bottom);		
		pane.setCenter(middle);

		Scene scene = new Scene(pane, 1024, 768);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fit4Life Login");
		primaryStage.show();
		
	}

}

    	