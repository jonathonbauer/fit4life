package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.AmenityTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import tables.Amenity;

public class CreateAmenityTab extends Tab {

	Database db = Database.getInstance();
	AmenityTable amenityTable;
	ArrayList<Amenity> amenities;
	Amenity amenity;
	
	public static CreateAmenityTab instance = null;
	
	private GridPane root;
	
	private Label amenName;
	
	private TextField amenBox;
	
	private Button create;
	
	public CreateAmenityTab() {
		
		//Get All Amenities from the Table
		this.amenityTable = new AmenityTable();
		//this.amenities = ArrayList<>();
		this.amenities = this.amenityTable.getAllAmenities();
		
		this.setText("Create an Amenity");
		
		this.root = new GridPane();
		
		this.root.setAlignment(Pos.TOP_CENTER);
		//Setting padding for GridPane
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));
		
		this.amenName = new Label("Amenity Name:");
		
		this.amenBox = new TextField();
		
		this.create = new Button("Create Amenity");
		
		this.root.add(amenName, 0, 1);
		this.root.add(amenBox, 1, 1);
		
		this.root.add(create, 1, 15);

		this.setContent(root);
	}

	public static CreateAmenityTab getInstance() {
		if(instance == null) {
			instance = new CreateAmenityTab();
			return instance;
		} else {
			return instance;
		}
		
	}
	}