package tabs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
import javabeans.ManagerTable;
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
import tables.Manager;
import tables.Member;


public class CreateManagersTab extends Tab {
	Database db = Database.getInstance();
	ManagerTable managerTable;
	ArrayList<Manager> managers;
	Manager manager;
	CityTable cityTable;
	
	public static CreateManagersTab instance = null;
	private GridPane root;
	
	private Label firstName;
	private Label lastName;
	private Label address;
	private Label postal;
	private Label city;
	
	private TextField fNameBox;
	private TextField lNameBox;
	private TextField addressBox;
	private TextField postalBox;
	
	private ComboBox<City> citiesBox;
	
	private Button create;
	
	public CreateManagersTab() {
		
		//Get All Amenities from the Table
		this.managerTable = new ManagerTable();
		this.managers = new ArrayList<>();
		this.managers = this.managerTable.getAllManagers();
		
		this.setText("New Manager");	
		this.root = new GridPane();
		
		this.root.setAlignment(Pos.CENTER);
		
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));
		
		this.firstName = new Label("First Name:");
		this.lastName = new Label("Last Name:");
		this.city = new Label("City:");
		this.address = new Label("Address:");
		this.postal = new Label("Postal Code:");
		
		this.fNameBox = new TextField();
		this.lNameBox = new TextField();
		this.addressBox = new TextField();
		this.postalBox = new TextField();
		
		
		this.cityTable = new CityTable();
		ArrayList<City> cities = this.cityTable.getAllCities();
		ArrayList<String> cityValues = new ArrayList<>();
		for(int i=0; i<cities.size(); i++) {
			cityValues.add(cities.get(i).getCity());
		}
		this.citiesBox = new ComboBox<City>(FXCollections.observableArrayList(this.cityTable.getAllCities()));
		
		
		this.create = new Button("Create Manager");
		
		this.create.setOnAction(e->{
          Manager newManager = new Manager();
          newManager.setFname(this.fNameBox.getText());
          newManager.setLname(this.lNameBox.getText());
          newManager.setAddress(this.addressBox.getText());
          newManager.setCity(this.citiesBox.getSelectionModel().getSelectedItem());
          newManager.setPostalCode(this.postalBox.getText());
          
          this.managerTable.createManager(newManager);
          
          ViewManagerTab viewManagerTab = ViewManagerTab.getInstance();
          viewManagerTab.managers.removeAll(viewManagerTab.managers);
          viewManagerTab.managers = viewManagerTab.managerTable.getAllManagers();
          viewManagerTab.table.setItems(FXCollections.observableArrayList(viewManagerTab.managers));
          
          System.out.print("The Create Manager Button Was Clicked");
        });
		
		
		this.root.add(firstName, 0, 1);
		this.root.add(fNameBox, 1, 1);
		
		this.root.add(lastName, 0, 2);
		this.root.add(lNameBox, 1, 2);
		
		this.root.add(address, 0, 3);
		this.root.add(addressBox, 1, 3);
		
		this.root.add(city, 0, 4);
		this.root.add(citiesBox, 1, 4);
		
		this.root.add(postal, 0, 5);
		this.root.add(postalBox, 1, 5);
		
		
		this.root.add(create, 1, 15);
	

		this.setContent(root);
	}

	public static CreateManagersTab getInstance() {
		if(instance == null) {
			instance = new CreateManagersTab();
			return instance;
		} else {
			return instance;
		}
		
	}

}
