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
	
	public CreateLocationTab() {
		
		
		this.locationTable = new LocationTable();
		this.locations = new ArrayList<>();
		this.locations = this.locationTable.getAllLocations();
		
		this.setText("New Location");
		
		this.root = new GridPane();
		this.root.setAlignment(Pos.TOP_CENTER);
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));
		
		this.locName = new Label("Location Name:");
		this.address = new Label("Address:");
		this.postal = new Label("Postal Code:");
		this.city = new Label("City:");
		
		this.nameBox = new TextField();
		this.addressBox = new TextField();
		this.postalBox = new TextField();
		
		this.cityTable = new CityTable();
		ArrayList<City> cities = this.cityTable.getAllCities();
		ArrayList<String> cityValues = new ArrayList<>();
		for(int i=0; i<cities.size(); i++) {
			cityValues.add(cities.get(i).getCity());
		}
		
		this.citiesBox = new ComboBox<City>(FXCollections.observableArrayList(this.cityTable.getAllCities()));
		
		this.create = new Button("Create Location");
		
		this.root.add(locName, 0, 1);
		this.root.add(nameBox, 1, 1);
		
		this.root.add(address, 0, 2);
		this.root.add(addressBox, 1, 2);
		
		this.root.add(postal, 0, 3);
		this.root.add(postalBox, 1, 3);
		
		this.root.add(city, 0, 4);
		this.root.add(citiesBox, 1, 4);
		
		this.root.add(create, 1, 15);
		
		
		
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
