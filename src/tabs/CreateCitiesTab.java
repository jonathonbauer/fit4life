package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import tables.City;



public class CreateCitiesTab extends Tab {
	Database db = Database.getInstance();
	CityTable cityTable;
	
	ArrayList<City> cities;
	City city;
	
	public static CreateCitiesTab instance = null;
	private GridPane root;
	
	private Label cityName;
	
	private TextField cityBox;
	
	private Button create;
	
	/**
	 * 
	 * This class is used to add new 'Cities' to the fit4life database
	 * <br/>
	 * It contains all the form elements needed to make a 'City' object
	 * and insert it into the Database
	 * 
	 * It also refreshes the table to make it visible on the viewCities Tab
	 *
	 */
	public CreateCitiesTab() {
		
		//Get All Cities from the Table
		this.cityTable = new CityTable();
		this.cities = new ArrayList<>();
		this.cities = this.cityTable.getAllCities();
		
		//Set the title of the Tab
		this.setText("New City");	
		
		//Create GridPane which all of the nodes are added too
		this.root = new GridPane();
		//Alignment of GridPane
		this.root.setAlignment(Pos.CENTER);
		//Setting padding for GridPane
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));               
		
		//Label Creation
		this.cityName = new Label("City Name:");
		//TextField Creation
		this.cityBox = new TextField();
		//Creating button which will push new data to the database
		this.create = new Button("Create City");
		
		this.create.setOnAction(e->{
           City newCity = new City();
           
           newCity.setCity(this.cityBox.getText());
           
           this.cityTable.createCity(newCity);
           System.out.print("Create City Button clicked");
           ViewCities viewCities = ViewCities.getInstance();
           viewCities.cities.removeAll(viewCities.cities);
           viewCities.cities = viewCities.cityTable.getAllCities();
           viewCities.table.setItems(FXCollections.observableArrayList(viewCities.cities));
           
          
           CreateMemberTab.getInstance().getCitiesBox().setItems(FXCollections.observableArrayList(this.cityTable.getAllCities()));
           CreateManagersTab.getInstance().getCitiesBox().setItems(FXCollections.observableArrayList(this.cityTable.getAllCities()));
           CreateLocationTab.getInstance().getCitiesBox().setItems(FXCollections.observableArrayList(this.cityTable.getAllCities()));
           ViewLocationTab.getInstance().getCityCombo().setItems(FXCollections.observableArrayList(this.cityTable.getAllCities()));
           ViewMemberTab.getInstance().getCityCombo().setItems(FXCollections.observableArrayList(this.cityTable.getAllCities()));
           ViewManagerTab.getInstance().getCityCombo().setItems(FXCollections.observableArrayList(this.cityTable.getAllCities()));
          
       
        });
		
		//Adding all the nodes to the GridPane
		this.root.add(cityName, 0, 1);
		this.root.add(cityBox, 1, 1);
		
		this.root.add(create, 1, 15);
		//Adding the GridPane to the Tab
		this.setContent(root);
	}

	// getInstance method used to get or create the ViewCities Tab
	public static CreateCitiesTab getInstance() {
		if(instance == null) {
			instance = new CreateCitiesTab();
			return instance;
		} else {
			return instance;
		}
		
	}

}