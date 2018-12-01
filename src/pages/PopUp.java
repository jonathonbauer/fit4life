package pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.Main;
import tabs.ViewMemberTab;

public class PopUp {
	private Scene scene;
	private BorderPane root;
	
	private HBox buttonBox;
	
	private Text confirmation;
	
	private Button yes;
	private Button no;
	
	// Constructor
	public PopUp() {
		
		// Confirmation Text
		this.confirmation = new Text("Are you sure you want to delete this record?");
		
		this.yes = new Button("Yes");
		this.yes.setMinWidth(75);
		
		this.yes.setOnAction(e->{
			ViewMemberTab.getInstance().setConfirm(true);
			Main.popUp.close();
		});
		
		
		this.no = new Button("No");
		this.no.setMinWidth(75);
		
		this.no.setOnAction(e->{
			ViewMemberTab.getInstance().setConfirm(false);
			Main.popUp.close();
		});
		
		
		
		this.buttonBox = new HBox(10);
		this.buttonBox.getChildren().addAll(this.yes, this.no);
		this.buttonBox.setAlignment(Pos.CENTER);
		
		this.root = new BorderPane();
		this.root.setCenter(this.confirmation);
		this.root.setBottom(this.buttonBox);
		
		BorderPane.setAlignment(this.confirmation, Pos.CENTER);
		BorderPane.setAlignment(this.buttonBox, Pos.CENTER);
		this.root.setPadding(new Insets(10,10,10,10));
		
		this.scene = new Scene(this.root, 300, 100);
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	
	
	
}
