package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import tables.City;



public class CreateCitiesTab extends Tab {
	Database db = Database.getInstance();
	CityTable cityTable;
	
	ArrayList<City> cities;
	City city;
	
	public static CreateCitiesTab instance = null;
	private GridPane root;
	
	public CreateCitiesTab() {
		
		//Get All Amenities from the Table
		this.cityTable = new CityTable();
		this.cities = new ArrayList<>();
		this.cities = this.cityTable.getAllCities();
		
		this.setText("Create a City");	
		this.root = new GridPane();
		
		

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