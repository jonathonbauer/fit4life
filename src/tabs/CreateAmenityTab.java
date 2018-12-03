package tabs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import database.Database;
import javabeans.AmenityTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import tables.Amenity;
import tables.Member;

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
	
	/**
	 * 
	 * This class is used to add new 'Amenities' to the fit4life database
	 * <br/>
	 * It contains all the form elements needed to make a 'Amenity' object
	 * and insert it into the Database
	 * 
	 * It also refreshes the table to make it visable on the viewAmenityTab
	 *
	 */
	public CreateAmenityTab() {
		
		
		//Get All Amenities from the Table
		this.amenityTable = new AmenityTable();
		this.amenities = this.amenityTable.getAllAmenities();
		//Set the title of the Tab
		this.setText("New Amenity");
		//Create GridPane which all of the nodes are added too
		this.root = new GridPane();
		//Alignment of GridPane
		this.root.setAlignment(Pos.CENTER);
		//Setting padding for GridPane
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));
		//Label Creation
		this.amenName = new Label("Amenity Name:");
		
		//TextField Creation
		this.amenBox = new TextField();
		//Creating button which will push new data to the database
		this.create = new Button("Create Amenity");
		
		this.create.setOnAction(e->{
            Amenity newAmenity = new Amenity();
            newAmenity.setAmenity(this.amenBox.getText());
            
            this.amenityTable.createAmenity(newAmenity);
            
         // Refresh the table
            ViewAmenityTab viewAmenityTab = ViewAmenityTab.getInstance();
            viewAmenityTab.amenities.removeAll(viewAmenityTab.amenities);
            viewAmenityTab.amenities = viewAmenityTab.amenityTable.getAllAmenities();
            viewAmenityTab.table.setItems(FXCollections.observableArrayList(viewAmenityTab.amenities));
        });
		//Adding all the nodes to the GridPane
		this.root.add(amenName, 0, 1);
		this.root.add(amenBox, 1, 1);
		
		this.root.add(create, 1, 15);
		//Adding the GridPane to the Tab
		this.setContent(root);
	}

	// getInstance method used to get or create the ViewAmenityTab
	public static CreateAmenityTab getInstance() {
		if(instance == null) {
			instance = new CreateAmenityTab();
			return instance;
		} else {
			return instance;
		}
		
	}
	}