package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.LocationTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import tables.Location;

public class UpdateLocationTab extends Tab {
	Database db = Database.getInstance();
	LocationTable locationTable;
	ArrayList<Location> locations;
	Location location;	

	public static UpdateLocationTab instance = null;
	
	private TableView<Location> table;
	private TableColumn<Location, Integer> idCol;
	private TableColumn<Location, String> nameCol;
	private TableColumn<Location, String> addressCol;
	private TableColumn<Location, String> postalCodeCol;
	private TableColumn<Location, String> cityCol;
	
	private BorderPane root;
	private Button refresh;
	
	public UpdateLocationTab() {
		this.locationTable = new LocationTable();
		//this.locations = ArrayList<>;
		this.locations = this.locationTable.getAllLocations();
		
		this.setText("Update a Location");
		
		// Declare columns & Give columns names
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
		this.table.setItems(FXCollections.observableArrayList(this.locations));
		
		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		this.addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		this.postalCodeCol.setCellValueFactory(new PropertyValueFactory("postalCode"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));
		
		table.getColumns().setAll(this.idCol, this.nameCol, this.addressCol, this.postalCodeCol, this.cityCol);
		
		this.refresh = new Button("Refresh");

		//Refreshes the page to get any added/removes records
		this.refresh.setOnAction(e->{
			//Code for refresh
		});
		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);
	
		this.setContent(root);
		
	}
	public static UpdateLocationTab getInstance() {
		if(instance == null) {
			instance = new UpdateLocationTab();
			return instance;
		} else {
			return instance;
		}
		
	}

}
