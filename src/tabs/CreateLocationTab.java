package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.LocationTable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tables.Location;

public class CreateLocationTab extends Tab {
	Database db = Database.getInstance();
	LocationTable locationTable;
	ArrayList<Location> locations;
	Location location;	
	
	public static CreateLocationTab instance = null;
	
	private BorderPane root;
	
	public CreateLocationTab() {
		
		//Get All Amenities from the Table
		this.locationTable = new LocationTable();
		//this.amenities = ArrayList<>();
		this.locations = this.locationTable.getAllLocations();
		
		this.setText("Create a Location");
		
		
		
		
		this.root = new BorderPane();

		this.setContent(root);
	}

	public static CreateLocationTab getInstance() {
		if(instance == null) {
			instance = new CreateLocationTab();
			return instance;
		} else {
			return instance;
		}
		
	}

}
