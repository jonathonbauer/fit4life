package tabs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import tables.City;
import tables.Member;



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
	
	public CreateCitiesTab() {
		
		//Get All Amenities from the Table
		this.cityTable = new CityTable();
		this.cities = new ArrayList<>();
		this.cities = this.cityTable.getAllCities();
		
		this.setText("New City");	
		
		this.root = new GridPane();
		
		this.root.setAlignment(Pos.TOP_CENTER);
		//Setting padding for GridPane
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));
		
		this.cityName = new Label("City Name:");
		
		this.cityBox = new TextField();
		
		this.create = new Button("Create City");
		
		this.create.setOnAction(e->{
           City newCity = new City();
           
           newCity.setCity(this.cityBox.getText());
           
           this.cityTable.updateCity(newCity);
           System.out.print("Create City Button clicked");
       
        });
		
		this.root.add(cityName, 0, 1);
		this.root.add(cityBox, 1, 1);
		
		this.root.add(create, 1, 15);
		
		
		

		this.setContent(root);
	}

	public static CreateCitiesTab getInstance() {
		if(instance == null) {
			instance = new CreateCitiesTab();
			return instance;
		} else {
			return instance;
		}
		
	}

}