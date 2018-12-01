package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
import javabeans.LocationTable;
import javabeans.MemberLevelTable;
import javabeans.MemberTable;
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
import tables.Member;
import tables.MemberLevel;

/*
 * This class is used to add new members to the Member Database 
 */

public class CreateMemberTab extends Tab {
	Database db = Database.getInstance();
	MemberTable memberTable;
	ArrayList<Member> members;
	Member member;
	MemberLevelTable memberLevelTable;
	CityTable cityTable;
	LocationTable locationTable;

	public static CreateMemberTab instance = null;

	private GridPane root;
	
	private Label firstName;
	private Label lastName;
	private Label city;
	private Label address;
	private Label level;
	private Label postal;
	private Label active;
	
	private Button create;
	
	
	private TextField fNameBox;
	private TextField lNameBox;
	private TextField addressBox;
	private TextField postalBox;
	
	private ComboBox<City> citiesBox;
	private ComboBox<MemberLevel> levelBox;
	private ComboBox<Boolean> activeBox;

	public CreateMemberTab() {
		//Get all members from the database
		this.memberTable = new MemberTable();
		this.members = new ArrayList<>();
		this.members = this.memberTable.getAllMembers();
		
		//Set the title of the Tab
		this.setText("New Member");	
		
		//Create GridPane which all of the nodes are added too
		this.root = new GridPane();
		
		//Alignment of GridPane
		this.root.setAlignment(Pos.TOP_CENTER);
		//Setting padding for GridPane
		this.root.setHgap(10);
		this.root.setVgap(10);
		this.root.setPadding(new Insets(25,25,25,25));
		
		//Label Creation
		this.firstName = new Label("First Name:");
		this.lastName = new Label("Last Name:");
		this.city = new Label("City:");
		this.address = new Label("Address:");
		this.level = new Label("Membership Level:");
		this.postal = new Label("Postal Code:");
		this.active = new Label("Active Membership:");
		
		//TextField Creation
		this.fNameBox = new TextField();
		this.lNameBox = new TextField();
		this.addressBox = new TextField();
		this.postalBox = new TextField();
		
		//Get membership levels from the database
		this.memberLevelTable = new MemberLevelTable();
		
		//Get cities from the database
		this.cityTable = new CityTable();
		ArrayList<City> cities = this.cityTable.getAllCities();
		ArrayList<String> cityValues = new ArrayList<>();
		for(int i=0; i<cities.size(); i++) {
			cityValues.add(cities.get(i).getCity());
		}
		//Get membership status from the database
		ArrayList<Boolean> activeValues = new ArrayList<>();
		activeValues.add(true);
		activeValues.add(false);
		
		//Creating the ComboBoxes for information from the database to be stored
		this.activeBox = new ComboBox<Boolean>(FXCollections.observableArrayList(activeValues));
		this.citiesBox = new ComboBox<City>(FXCollections.observableArrayList(this.cityTable.getAllCities()));
		this.levelBox = new ComboBox<MemberLevel>(FXCollections.observableArrayList(this.memberLevelTable.getAllMemberLevels()));
		
	
		//Creating button which will push new data to the database
		this.create = new Button("Create Member");
		
		
		//Adding all the nodes to the GridPane
		this.root.add(firstName, 0, 1);
		this.root.add(fNameBox, 1, 1);
		
		this.root.add(lastName, 0, 2);
		this.root.add(lNameBox, 1, 2);
		
		this.root.add(address, 0, 3);
		this.root.add(addressBox, 1, 3);
		
		this.root.add(city, 0, 4);
		this.root.add(citiesBox, 1, 4);
		
		this.root.add(level, 0, 5);
		this.root.add(levelBox, 1, 5);
		
		this.root.add(postal, 0, 6);
		this.root.add(postalBox, 1, 6);
		
		this.root.add(active, 0, 7);
		this.root.add(activeBox, 1, 7);
		

		this.root.add(create, 1, 15);
		
		
		
		
		
		
		
		
		
		
		//Adding the GridPane to the Tab
		this.setContent(root);
	}
	// getInstance method used to get or create the ViewMemberTab
	public static CreateMemberTab getInstance() {
		if(instance == null) {
			instance = new CreateMemberTab();
			return instance;
		} else {
			return instance;
		}

	}

}
