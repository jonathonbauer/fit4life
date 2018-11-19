package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.AmenityTable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tables.Amenity;

public class CreateAmenityTab extends Tab {

	Database db = Database.getInstance();
	AmenityTable amenityTable;
	ArrayList<Amenity> amenities;
	Amenity amenity;
	
	public static CreateAmenityTab instance = null;
	
	private BorderPane root;
	
	public CreateAmenityTab() {
		
		//Get All Amenities from the Table
		this.amenityTable = new AmenityTable();
		//this.amenities = ArrayList<>();
		this.amenities = this.amenityTable.getAllAmenities();
		
		this.setText("Create an Amenity");
		
		
		
		
		this.root = new BorderPane();

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