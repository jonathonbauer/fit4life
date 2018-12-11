package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
import javabeans.LocationTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import tables.City;
import tables.Location;
import tables.Manager;

public class CreateLocationTab extends Tab {
	Database db = Database.getInstance();
	LocationTable locationTable;
	ArrayList<Location> locations;
	CityTable cityTable;
	Location location;	
	
	public static CreateLocationTab instance = null;
	
	private GridPane root;
	
	private Label locName;
	private Label address;
	private Label postal;
	private Label city;
	
	private Button create;
	
	private TextField nameBox;
	private TextField addressBox;
	private TextField postalBox;
	
	private ComboBox<City> citiesBox;
	
	/**
	 * 
	 * This class is used to add new 'Locations' to the fit4life database
	 * <br/>
	 * It contains all the form elements needed to make a 'Location' object
	 * and insert it into the Database
	 * 
	 * It also refreshes the table to make it visible on the viewLocationsTab
	 *
	 */
	public CreateLocationTab() {
		
		//Get all locations from the database
		this.locationTable = new LocationTable();
		this.locations = new ArrayList<>();
		this.locations = this.locationTable.getAllLocations();
		//Set the title of the Tab
		this.setText("New Location");
		//Create GridPane which all of the nodes are added too
		this.root = new GridPane();
		//Alignment of GridPane
		this.root.setAlignment(Pos.CENTER);
		//Setting padding for GridPane
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));
		
		//Label Creation
		this.locName = new Label("Location Name:");
		this.address = new Label("Address:");
		this.postal = new Label("Postal Code:");
		this.city = new Label("City:");
		
		//TextField Creation
		this.nameBox = new TextField();
		this.addressBox = new TextField();
		this.postalBox = new TextField();
		
		//Get cities from the database
		this.cityTable = new CityTable();
		ArrayList<City> cities = this.cityTable.getAllCities();
		ArrayList<String> cityValues = new ArrayList<>();
		for(int i=0; i<cities.size(); i++) {
			cityValues.add(cities.get(i).getCity());
		}
		//Creating the ComboBoxes for information from the database to be stored
		this.citiesBox = new ComboBox<City>(FXCollections.observableArrayList(this.cityTable.getAllCities()));
		
		//Creating button which will push new data to the database
		this.create = new Button("Create Location");
		
		this.create.setOnAction(e->{
			Location newLocation = new Location();
			
			newLocation.setName(this.nameBox.getText());
			newLocation.setAddress(this.addressBox.getText());
			newLocation.setPostalCode(this.postalBox.getText());
			newLocation.setCity(this.citiesBox.getSelectionModel().getSelectedItem());
			
			this.locationTable.createLocation(newLocation);
			System.out.println("Create Location Button clicked");
			
			 // Refresh the table
			 ViewLocationTab viewLocationTab = ViewLocationTab.getInstance();
			 viewLocationTab.locations.removeAll(viewLocationTab.locations);
			 viewLocationTab.locations = viewLocationTab.locationTable.getAllLocations();
			 viewLocationTab.table.setItems(FXCollections.observableArrayList(viewLocationTab.locations));
			 
			 CreateMemberTab.getInstance().getLocationBox().setItems(FXCollections.observableArrayList(this.locationTable.getAllLocations()));
			 ViewMemberTab.getInstance().getLocationCombo().setItems(FXCollections.observableArrayList(this.locationTable.getAllLocations()));
			 
	        });
		
		//Adding all the nodes to the GridPane
		this.root.add(locName, 0, 1);
		this.root.add(nameBox, 1, 1);
		
		this.root.add(address, 0, 2);
		this.root.add(addressBox, 1, 2);
		
		this.root.add(postal, 0, 3);
		this.root.add(postalBox, 1, 3);
		
		this.root.add(city, 0, 4);
		this.root.add(citiesBox, 1, 4);
		
		this.root.add(create, 1, 15);
		
		
		//Adding the GridPane to the Tab
		this.setContent(root);
	}

	// getInstance method used to get or create the ViewLocationTab
	public static CreateLocationTab getInstance() {
		if(instance == null) {
			instance = new CreateLocationTab();
			return instance;
		} else {
			return instance;
		}
		
	}

	public ComboBox<City> getCitiesBox() {
		return citiesBox;
	}

	public void setCitiesBox(ComboBox<City> citiesBox) {
		this.citiesBox = citiesBox;
	}

	
}
