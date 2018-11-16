package tabs;

import java.util.ArrayList;
import java.util.Date;

import database.Database;
import javabeans.MemberTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import tables.Member;

public class UpdateMemberTab extends Tab {
	Database db = Database.getInstance();
	MemberTable memberTable;
	ArrayList<Member> members;
	Member member;	

	public static UpdateMemberTab instance = null;
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


	public UpdateMemberTab() {
		this.memberTable = new MemberTable();
		this.members = new ArrayList<>();
		this.members = this.memberTable.getAllMembers();

		this.setText("Update A Member");


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


		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.members));


		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		this.addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		this.postalCodeCol.setCellValueFactory(new PropertyValueFactory("postalCode"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));
		this.activeMemberCol.setCellValueFactory(new PropertyValueFactory("activeMembership"));
		this.memberLevelCol.setCellValueFactory(new PropertyValueFactory("membershipLevel"));
		this.regDateCol.setCellValueFactory(new PropertyValueFactory("registrationDate"));



		TableColumn<Member, String> firstNameCol = new TableColumn<Member,String>("Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));


		TableColumn<Member,String> lastNameCol = new TableColumn<Member,String>("Address");
		lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

		table.getColumns().setAll(this.idCol, this.nameCol, this.addressCol, this.postalCodeCol, this.cityCol,
				this.activeMemberCol, this.memberLevelCol, this.regDateCol);


		this.refresh = new Button("Refresh");


		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);

		this.setContent(root);
	}

	public static UpdateMemberTab getInstance() {
		if(instance == null) {
			instance = new UpdateMemberTab();
			return instance;
		} else {
			return instance;
		}

	}

}
