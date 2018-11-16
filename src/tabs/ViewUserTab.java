package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.UserTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import tables.User;

/**
 * 
 *  This class is used to display the all users in the User Database
 *  It utilizes a TableView to display all information
 *  This class follows the Singleton design pattern
 *
 */
public class ViewUserTab extends Tab {
	Database db = Database.getInstance();
	UserTable userTable;
	ArrayList<User> users;
	User user;	

	public static ViewUserTab instance = null;
	private Button refresh;
	private TableView<User> table;
	private TableColumn<User, Integer> idCol;
	private TableColumn<User, String> usernameCol;

	private BorderPane root;


	public ViewUserTab() {
		// Set the title text of the tab
		this.setText("View Users");
		
		// Get all the users from the database
		this.userTable = new UserTable();
		this.users = new ArrayList<>();
		this.users = this.userTable.getAllUsers();
		
		
		// Declare the Columns and give them titles
		this.idCol = new TableColumn<>();
		this.idCol.setText("ID");
		
		this.usernameCol = new TableColumn<>();
		this.usernameCol.setText("Username");
		
		// Get the values for the columns 
		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.usernameCol.setCellValueFactory(new PropertyValueFactory("username"));
		
		// Declare the table and set the values to the users arraylist
		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.users));
		this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		// Add the columns to the table
		table.getColumns().setAll(this.idCol, this.usernameCol);
		
		
		// Declare the refresh button and give it an action handler that refreshes the table
		this.refresh = new Button("Refresh");

		this.refresh.setOnAction(e->{
			this.users.removeAll(this.users);
			this.users = this.userTable.getAllUsers();
			this.table.setItems(FXCollections.observableArrayList(this.users));
			System.out.println("Table Refreshed");
		});
		
		// Declare the borderpane, and set the nodes to its center and bottom
		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);
		
		// Set the alignment, padding and margin of the borderpane
		this.root.setPadding(new Insets(10,10,10,10));
		BorderPane.setAlignment(this.refresh, Pos.CENTER);
		BorderPane.setMargin(this.refresh, new Insets(5,5,5,5));
		
		// Set the content of the tab to the borderpane
		this.setContent(root);
	}

	// getInstance method used to get or create the ViewUserTab
	public static ViewUserTab getInstance() {
		if(instance == null) {
			instance = new ViewUserTab();
			return instance;
		} else {
			return instance;
		}

	}

}
