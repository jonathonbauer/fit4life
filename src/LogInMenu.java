import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
		
		
		
		
		

		Scene scene = new Scene(pane, 1024, 768);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fit4Life Login");
		primaryStage.show();
		
	}

}

    	