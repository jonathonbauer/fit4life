package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.AmenityTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import tables.Amenity;

public class UpdateAmenityTab extends Tab {

	Database db = Database.getInstance();
	AmenityTable amenityTable;
	ArrayList<Amenity> amenities;
	Amenity amenity;
	
	public static UpdateAmenityTab instance = null;
	private TableView<Amenity> table;
	private TableColumn<Amenity, Integer> idCol;
	private TableColumn<Amenity, String> amenityCol;
	
	private Button refresh;
	private BorderPane root;
	
	public UpdateAmenityTab() {
		
		//Get All Amenities from the Table
		this.amenityTable = new AmenityTable();
		//this.amenities = ArrayList<>();
		this.amenities = this.amenityTable.getAllAmenities();
		
		this.setText("Update Amenities");
		
		this.idCol = new TableColumn<>();
		this.idCol.setText("ID");
		
		this.amenityCol = new TableColumn<>();
		this.amenityCol.setText("Amenity");
		
		
		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.amenities));
		
		//Get columns values
		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.amenityCol.setCellValueFactory(new PropertyValueFactory("Amenity"));
		
		//Add columns to the table
		table.getColumns().setAll(this.idCol, this.amenityCol);
		
		this.refresh = new Button("Refresh");

		//Refreshes the page to get any added/removes records
		this.refresh.setOnAction(e->{
		//Code for refresh button
		});
		
		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);
		
		this.setContent(root);
	}

	public static UpdateAmenityTab getInstance() {
		if(instance == null) {
			instance = new UpdateAmenityTab();
			return instance;
		} else {
			return instance;
		}
		
	}
	}



