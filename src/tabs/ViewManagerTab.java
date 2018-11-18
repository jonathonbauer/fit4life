package tabs;

import java.util.ArrayList;
import java.util.Date;

import database.Database;
import javabeans.ManagerTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import tables.Manager;

public class ViewManagerTab extends Tab {
	Database db = Database.getInstance();
	ManagerTable managerTable;
	ArrayList<Manager> managers;
	Manager manager;	

	public static ViewManagerTab instance = null;
	private Button refresh;
	private TableView<Manager> table;
	private TableColumn<Manager, Integer> idCol;
	private TableColumn<Manager, String> nameCol;
	private TableColumn<Manager, String> addressCol;
	private TableColumn<Manager, String> postalCodeCol;
	private TableColumn<Manager, String> cityCol;
	

	private BorderPane root;


	public ViewManagerTab() {
		this.managerTable = new ManagerTable();
		this.managers = new ArrayList<>();
		this.managers = this.managerTable.getAllManagers();

		this.setText("View Managers");


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

		


		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.managers));


		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		this.addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		this.postalCodeCol.setCellValueFactory(new PropertyValueFactory("postalCode"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));
		


		TableColumn<Manager, String> firstNameCol = new TableColumn<Manager,String>("Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));


		TableColumn<Manager,String> lastNameCol = new TableColumn<Manager,String>("Address");
		lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

		table.getColumns().setAll(this.idCol, this.nameCol, this.addressCol, this.postalCodeCol, this.cityCol);


		this.refresh = new Button("Refresh");
		
		this.refresh.setOnAction(e->{
			this.managers.removeAll(this.managerss);
			this.managers = this.managerTable.getAllManagers();
			this.table.setItems(FXCollections.observableArrayList(this.managers));
			System.out.println("Table Refreshed");
		});


		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);

		this.setContent(root);
	}

	public static ViewManagerTab getInstance() {
		if(instance == null) {
			instance = new ViewManagerTab();
			return instance;
		} else {
			return instance;
		}

	}

}
