package tabs;

import java.util.ArrayList;
import java.util.Date;

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
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import tables.City;
import tables.Location;
import tables.Member;
import tables.MemberLevel;
/**
 * 
 *  This class is used to display the all members in the Member Database
 *  It utilizes a TableView to display all information
 *  This class follows the Singleton design pattern
 *
 */
public class ViewMemberTab extends Tab {
	Database db = Database.getInstance();
	MemberTable memberTable;
	CityTable cityTable;
	MemberLevelTable memberLevelTable;
	LocationTable locationTable;
	ArrayList<Member> members;
	Member member;	

	public static ViewMemberTab instance = null;
	private TableView<Member> table;
	private TableColumn<Member, Integer> idCol;
	private TableColumn<Member, String> fnameCol;
	private TableColumn<Member, String> lnameCol;
	private TableColumn<Member, String> addressCol;
	private TableColumn<Member, String> postalCodeCol;
	private TableColumn<Member, String> cityCol;
	private TableColumn<Member, Boolean> activeMemberCol;
	private TableColumn<Member, String> memberLevelCol;
	private TableColumn<Member, String> locationCol;
	private TableColumn<Member, Date> regDateCol;

	private GridPane memberInfo;

	private Text id;
	private Text memberId;

	private Text fname;
	private TextField fnameTf;

	private Text lname;
	private TextField lnameTf;

	private Text address;
	private TextField addressTf;

	private Text postalCode;
	private TextField postalCodeTF;

	private Text city;
	private ComboBox<City> cityCombo;

	private Text active;
	private ComboBox<Boolean> activeCombo;

	private Text level;
	private ComboBox<MemberLevel> levelCombo;

	private Text location;
	private ComboBox<Location> locationCombo;

	private Text date;
	private Text regDate;

	private Button update;
	private Button delete;

	private HBox buttons;

	private BorderPane root;


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ViewMemberTab() {
		// Get all the members from the database
		this.memberTable = new MemberTable();
		this.members = new ArrayList<>();
		this.members = this.memberTable.getAllMembers();

		// Set the title text of the tab
		this.setText("View Members");

		// Declare the Columns and give them titles
		this.idCol = new TableColumn<>();
		this.idCol.setText("ID");
		this.idCol.setMaxWidth(1500);		
		
		this.fnameCol = new TableColumn<>();
		this.fnameCol.setText("First Name");

		this.lnameCol = new TableColumn<>();
		this.lnameCol.setText("Last Name");

		this.addressCol = new TableColumn<>();
		this.addressCol.setText("Address");

		this.postalCodeCol = new TableColumn<>();
		this.postalCodeCol.setText("Postal Code");

		this.cityCol = new TableColumn<>();
		this.cityCol.setText("City");

		this.activeMemberCol = new TableColumn<>();
		this.activeMemberCol.setText("Active Membership");

		this.memberLevelCol = new TableColumn<>();
		this.memberLevelCol.setText("Membership Level");

		this.locationCol = new TableColumn<>();
		this.locationCol.setText("Location");

		this.regDateCol = new TableColumn<>();
		this.regDateCol.setText("Registration Date");

		// Declare the table and set the values to the members arraylist
		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.members));
		this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		// Get the values for the columns 
		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.fnameCol.setCellValueFactory(new PropertyValueFactory("fname"));
		this.lnameCol.setCellValueFactory(new PropertyValueFactory("lname"));
		this.addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		this.postalCodeCol.setCellValueFactory(new PropertyValueFactory("postalCode"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));
		this.activeMemberCol.setCellValueFactory(new PropertyValueFactory("activeMembership"));
		this.memberLevelCol.setCellValueFactory(new PropertyValueFactory("membershipLevel"));
		this.locationCol.setCellValueFactory(new PropertyValueFactory("location"));
		this.regDateCol.setCellValueFactory(new PropertyValueFactory("registrationDate"));


		// Add the columns to the table
		table.getColumns().setAll(this.idCol, this.fnameCol, this.lnameCol, this.addressCol, this.postalCodeCol, this.cityCol,
				this.activeMemberCol, this.memberLevelCol, this.locationCol, this.regDateCol);



		// Information Beneath Table
		this.memberInfo = new GridPane();


		// Column 1
		this.id = new Text("Member ID:");
		this.memberId = new Text("0");

		this.fname = new Text("First Name:");
		this.fnameTf = new TextField();

		this.lname = new Text("Last Name:");
		this.lnameTf = new TextField();

		this.date = new Text("Registration Date:");
		this.regDate = new Text("0000-00-00");

		this.memberLevelTable = new MemberLevelTable();
		this.level = new Text("Membership Level:");
		this.levelCombo = new ComboBox(FXCollections.observableArrayList(this.memberLevelTable.getAllMemberLevels()));

		// Column 2
		this.address = new Text("Address:");
		this.addressTf = new TextField();

		this.cityTable = new CityTable();
		ArrayList<City> cities = this.cityTable.getAllCities();
		ArrayList<String> cityValues = new ArrayList<>();
		for(int i=0; i<cities.size(); i++) {
			cityValues.add(cities.get(i).getCity());
		}
		
		this.city = new Text("City:");
		this.cityCombo = new ComboBox(FXCollections.observableArrayList(this.cityTable.getAllCities()));

		this.locationTable = new LocationTable();
		ArrayList<Location> locations = this.locationTable.getAllLocations();
		ArrayList<String> locationValues = new ArrayList<>();
		for(int i=0; i<locations.size(); i++) {
			locationValues.add(locations.get(i).getName());
		}
		
		this.location = new Text("Location:");
		this.locationCombo = new ComboBox(FXCollections.observableArrayList(this.locationTable.getAllLocations()));
		this.postalCode = new Text("Postal Code:");
		this.postalCodeTF = new TextField();

		ArrayList<Boolean> activeValues = new ArrayList<>();
		activeValues.add(true);
		activeValues.add(false);
		this.active = new Text("Active Membership:");
		this.activeCombo = new ComboBox(FXCollections.observableArrayList(activeValues));

		// Add the Member Information Boxes to the Screen
		this.memberInfo.add(this.id, 0, 0);
		this.memberInfo.add(this.memberId, 1, 0);
		this.memberInfo.add(this.fname, 0, 1);
		this.memberInfo.add(this.fnameTf, 1, 1);
		this.memberInfo.add(this.lname, 0, 2);
		this.memberInfo.add(this.lnameTf, 1, 2);
		this.memberInfo.add(this.date, 0, 3);
		this.memberInfo.add(this.regDate, 1, 3);
		this.memberInfo.add(this.level, 0, 4);
		this.memberInfo.add(this.levelCombo, 1, 4);

		this.memberInfo.add(this.address, 2, 0);
		this.memberInfo.add(this.addressTf, 3, 0);
		this.memberInfo.add(this.city, 2, 1);
		this.memberInfo.add(this.cityCombo, 3, 1);
		this.memberInfo.add(this.postalCode, 2, 2);
		this.memberInfo.add(this.postalCodeTF, 3, 2);
		this.memberInfo.add(this.active, 2, 3);
		this.memberInfo.add(this.activeCombo, 3, 3);
		this.memberInfo.add(this.location, 2, 4);
		this.memberInfo.add(this.locationCombo, 3, 4);


		// Create the buttons and add them to the HBox
		this.update = new Button("Update");
		this.delete = new Button("Delete");

		this.buttons = new HBox();
		this.buttons.getChildren().addAll(this.update, this.delete);
		this.buttons.setAlignment(Pos.CENTER);
		this.buttons.setSpacing(50);
		
		this.memberInfo.add(this.buttons, 0, 5, 5, 1);

		// Set the values when a user is selected
		this.table.getSelectionModel().selectedItemProperty().addListener(e->{
			Member selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				this.fnameTf.setText(selected.getFname());
				this.lnameTf.setText(selected.getLname());
				this.memberId.setText(selected.getId() + "");
				this.regDate.setText(selected.getRegistrationDate() + "");
				this.levelCombo.getSelectionModel().select(selected.getMembershipLevel());
				this.addressTf.setText(selected.getAddress());
				this.cityCombo.getSelectionModel().select(selected.getCity());
				this.postalCodeTF.setText(selected.getPostalCode());
				this.activeCombo.getSelectionModel().select(selected.getActiveMembership());
				this.locationCombo.getSelectionModel().select(selected.getLocation());
			}
		});


		// Button Event Handlers

		this.update.setOnAction(e->{
			Member selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				selected.setFname(this.fnameTf.getText());
				selected.setLname(this.lnameTf.getText());
				selected.setMembershipLevel(this.levelCombo.getSelectionModel().getSelectedItem());
				selected.setAddress(this.addressTf.getText());
				selected.setCity(this.cityCombo.getSelectionModel().getSelectedItem());
				selected.setPostalCode(this.postalCodeTF.getText());
				selected.setActiveMembership(this.activeCombo.getSelectionModel().getSelectedItem());
				selected.setLocation(this.locationCombo.getSelectionModel().getSelectedItem());
				
				this.memberTable.updateMember(selected);
				
				this.members.removeAll(this.members);
				this.members = this.memberTable.getAllMembers();
				this.table.setItems(FXCollections.observableArrayList(this.members));
				
				this.table.getSelectionModel().select(selected);
			} else {
				System.out.println("Nothing was selected!");
			}
		});

		// Add the items to the root borderpane
		this.root = new BorderPane();
		this.root.setTop(this.table);
		this.root.setCenter(this.memberInfo);
		this.root.setMaxHeight(600);
		
		// Styling
		this.memberInfo.setHgap(25);
		this.memberInfo.setVgap(10);
		this.memberInfo.setPadding(new Insets(10,10,10,10));
		this.memberInfo.setAlignment(Pos.TOP_CENTER);

		
		BorderPane.setAlignment(this.memberInfo, Pos.CENTER);
		BorderPane.setAlignment(this.buttons, Pos.TOP_CENTER);
		BorderPane.setMargin(this.buttons, new Insets(50,50,50,50));
		BorderPane.setMargin(this.table, new Insets(10,10,10,10));

		this.setContent(root);
	}

	// getInstance method used to get or create the ViewMemberTab
	public static ViewMemberTab getInstance() {
		if(instance == null) {
			instance = new ViewMemberTab();
			return instance;
		} else {
			return instance;
		}

	}

}
