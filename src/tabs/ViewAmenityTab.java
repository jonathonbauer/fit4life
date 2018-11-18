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

public class ViewAmenityTab extends Tab {
	Database db = Database.getInstance();
	AmenityTable amenityTable;
	ArrayList<Amenity> amenities;
	Amenity amenity;
	
	public static ViewAmenityTab instance = null;
	private TableView<Amenity> table;
	private TableColumn<Amenity, Integer> idCol;
	private TableColumn<Amenity, String> amenityCol;
	
	private Button refresh;
	private BorderPane root;
	
	public ViewAmenityTab() {
		
		//Get All Amenities from the Table
		this.amenityTable = new AmenityTable();
		this.amenities = ArrayList<>();
		this.amenities = this.amenityTable.getAllAmenities();
		
		this.idCol = new TableColumn<>();
		this.idCol.setText("ID");
		
		this.amenityCol = new TableColumn<>();
		this.amenityCol.setText("Amenity");
		
		
		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.amenities));
		this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		//Get columns values
		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.amenityCol.setCellValueFactory(new PropertyValueFactory("Amenity"));
		
		//Add columns to the table
		table.getColumns().setAll(this.idCol, this.amenityCol);
		
		this.refresh = new Button("Refresh");

		//Refreshes the page to get any added/removes records
		this.refresh.setOnAction(e->{
			this.amenities.removeAll(this.amenities);
			this.amenities = this.amenityTable.getAllAmenities();
			this.table.setItems(FXCollections.observableArrayList(this.amenities));
		});
		
		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);
		
		this.root.setPadding(new Insets(10,10,10,10));
		BorderPane.setAlignment(this.refresh, Pos.CENTER);
		BorderPane.setMargin(this.refresh, new Insets(5,5,5,5));
			

		this.setContent(root);
	}
	
	public static ViewAmenityTab getInstance() {
		if(instance == null) {
			instance = new ViewAmenityTab();
			return instance;
		} else {
			return instance;
		}
		
	}
	}


