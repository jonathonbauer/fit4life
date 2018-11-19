package tabs;

import java.util.ArrayList;
import java.util.Date;

import database.Database;
import javabeans.CityTable;
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
import javafx.scene.text.Text;
import tables.City;
import tables.Member;
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
	ArrayList<Member> members;
	Member member;	

	public static ViewMemberTab instance = null;
	private Button refresh;
	private TableView<Member> table;
	private TableColumn<Member, Integer> idCol;
	private TableColumn<Member, String> nameCol;
	private TableColumn<Member, String> addressCol;
	private TableColumn<Member, String> postalCodeCol;
	private TableColumn<Member, String> cityCol;
	private TableColumn<Member, Boolean> activeMemberCol;
	private TableColumn<Member, String> memberLevelCol;
	private TableColumn<Member, Date> regDateCol;
	
	private GridPane memberInfo;
	
	private Text id;
	private Text memberId;
	
	private Text name;
	private TextField nameTf;
	
	private Text address;
	private TextField addressTf;
	
	private Text postalCode;
	private TextField postalCodeTF;
	
	private Text city;
	private ComboBox cityCombo;
	
	private Text active;
	private ComboBox activeCombo;
	
	private Text level;
	private ComboBox levelCombo;
	
	private Text date;
	private Text regDate;
	
	
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
		
		this.nameCol = new TableColumn<>();
		this.nameCol.setText("Name");

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

		this.regDateCol = new TableColumn<>();
		this.regDateCol.setText("Registration Date");

		// Declare the table and set the values to the members arraylist
		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.members));
		this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//		this.table.setMaxHeight(350);
		
		// Get the values for the columns 
		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		this.addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		this.postalCodeCol.setCellValueFactory(new PropertyValueFactory("postalCode"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));
		this.activeMemberCol.setCellValueFactory(new PropertyValueFactory("activeMembership"));
		this.memberLevelCol.setCellValueFactory(new PropertyValueFactory("membershipLevel"));
		this.regDateCol.setCellValueFactory(new PropertyValueFactory("registrationDate"));


		// Add the columns to the table
		table.getColumns().setAll(this.idCol, this.nameCol, this.addressCol, this.postalCodeCol, this.cityCol,
				this.activeMemberCol, this.memberLevelCol, this.regDateCol);

	
		
		// Information Beneath Table
		this.memberInfo = new GridPane();
		
		
		// Column 1
		this.id = new Text("Member ID:");
		this.memberId = new Text("0");
		
		this.name = new Text("Name:");
		this.nameTf = new TextField();
		
		this.date = new Text("Registration Date:");
		this.regDate = new Text("0000-00-00");
		
		this.memberLevelTable = new MemberLevelTable();
		this.level = new Text("Membership Level:");
//		this.levelCombo = new ComboBox(FXCollections.observableArrayList(this.memberLevelTable.getAllMemberLevels()));
		this.levelCombo = new ComboBox();
		
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
		this.cityCombo = new ComboBox(FXCollections.observableArrayList(cityValues));
		
		this.postalCode = new Text("Postal Code:");
		this.postalCodeTF = new TextField();
		
		ArrayList<String> activeValues = new ArrayList<>();
		activeValues.add("Yes");
		activeValues.add("No");
		this.active = new Text("Active Membership:");
		this.activeCombo = new ComboBox(FXCollections.observableArrayList(activeValues));
		
		// Add the Member Information Boxes to the Screen
		this.memberInfo.add(this.id, 0, 0);
		this.memberInfo.add(this.memberId, 1, 0);
		this.memberInfo.add(this.name, 0, 1);
		this.memberInfo.add(this.nameTf, 1, 1);
		this.memberInfo.add(this.date, 0, 2);
		this.memberInfo.add(this.regDate, 1, 2);
		this.memberInfo.add(this.level, 0, 3);
		this.memberInfo.add(this.levelCombo, 1, 3);
	
		this.memberInfo.add(this.address, 2, 0);
		this.memberInfo.add(this.addressTf, 3, 0);
		this.memberInfo.add(this.city, 2, 1);
		this.memberInfo.add(this.cityCombo, 3, 1);
		this.memberInfo.add(this.postalCode, 2, 2);
		this.memberInfo.add(this.postalCodeTF, 3, 2);
		this.memberInfo.add(this.active, 2, 3);
		this.memberInfo.add(this.activeCombo, 3, 3);
		
		this.table.getSelectionModel().selectedItemProperty().addListener(e->{
			Member selected = this.table.getSelectionModel().getSelectedItem();
			this.nameTf.setText(selected.getName());
			this.memberId.setText(selected.getId() + "");
			this.regDate.setText(selected.getRegistrationDate() + "");
			this.levelCombo.getSelectionModel().select("Gold");
			this.addressTf.setText(selected.getAddress());
			this.cityCombo.getSelectionModel().select("Windsor");
			this.postalCodeTF.setText(selected.getPostalCode());
			if(selected.getActiveMembership()) {
				this.activeCombo.getSelectionModel().select(0);
			} else {
				this.activeCombo.getSelectionModel().select(1);
			}
		});
		
	

		
		// Add the items to the root borderpane
		this.root = new BorderPane();
		this.root.setTop(this.table);
		root.setCenter(this.memberInfo);
		
		// Styling
		this.root.setPadding(new Insets(10,10,10,10));
		this.memberInfo.setGridLinesVisible(true);
		BorderPane.setAlignment(this.memberInfo, Pos.CENTER);
//		BorderPane.setMargin(this.refresh, new Insets(5,5,5,5));
			

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
