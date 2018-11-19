package tabs;

import java.util.ArrayList;
import java.util.Date;

import database.Database;
import javabeans.MemberTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
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

		// Declare the refresh button and give it an action handler that refreshes the table
		this.refresh = new Button("Refresh");

		this.refresh.setOnAction(e->{
			this.members.removeAll(this.members);
			this.members = this.memberTable.getAllMembers();
			this.table.setItems(FXCollections.observableArrayList(this.members));
			System.out.println("Table Refreshed");
		});
		
		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);
		
		this.root.setPadding(new Insets(10,10,10,10));
		BorderPane.setAlignment(this.refresh, Pos.CENTER);
		BorderPane.setMargin(this.refresh, new Insets(5,5,5,5));
			

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
