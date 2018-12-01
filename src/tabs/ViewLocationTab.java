package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
import javabeans.LocationTable;
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

public class ViewLocationTab extends Tab {
	Database db = Database.getInstance();
	LocationTable locationTable;
	CityTable cityTable;
	ArrayList<Location> locations;
	Location location;	

	public static ViewLocationTab instance = null;

	private TableView<Location> table;
	private TableColumn<Location, Integer> idCol;
	private TableColumn<Location, String> nameCol;
	private TableColumn<Location, String> addressCol;
	private TableColumn<Location, String> postalCodeCol;
	private TableColumn<Location, String> cityCol;

	private GridPane locationInfo;

	private Text id;
	private Text locationId;

	private Text name;
	private TextField nameTf;

	private Text address;
	private TextField addressTf;

	private Text postalCode;
	private TextField postalCodeTf;

	private Text city;
	private ComboBox<City> cityCombo;	

	private Button update;
	private Button delete;

	private HBox buttons;

	private BorderPane root;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ViewLocationTab() {
		this.locationTable = new LocationTable();
		//this.locations = ArrayList<>();
		this.locations = this.locationTable.getAllLocations();

		this.setText("All Locations");

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
		this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		this.addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		this.postalCodeCol.setCellValueFactory(new PropertyValueFactory("postalCode"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));

		table.getColumns().setAll(this.idCol, this.nameCol, this.addressCol, this.postalCodeCol, this.cityCol);

		// Information Beneath Table
		this.locationInfo = new GridPane();

		this.id = new Text("Location ID");
		this.locationId = new Text("0");

		this.name = new Text("Name");
		this.nameTf = new TextField();

		this.address = new Text("Address");
		this.addressTf = new TextField();

		this.postalCode = new Text("Postal Code");
		this.postalCodeTf = new TextField();

		this.cityTable = new CityTable();
		this.city = new Text("City");
		this.cityCombo = new ComboBox(FXCollections.observableArrayList(this.cityTable.getAllCityNames()));	
		
		
		// Add the nodes to the GridPane
		this.locationInfo.add(this.id, 2, 0);
		this.locationInfo.add(this.locationId, 3, 0);
		this.locationInfo.add(this.name, 1, 1);
		this.locationInfo.add(this.nameTf, 2, 1);
		this.locationInfo.add(this.address, 3, 1);
		this.locationInfo.add(this.addressTf, 4, 1);
		this.locationInfo.add(this.postalCode, 1, 2);
		this.locationInfo.add(this.postalCodeTf, 2, 2);
		this.locationInfo.add(this.city, 3, 2);
		this.locationInfo.add(this.cityCombo, 4, 2);
		
		
		
		// Set the values when a user is selected
		this.table.getSelectionModel().selectedItemProperty().addListener(e->{
			Location selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				this.locationId.setText(selected.getId() + "");
				this.nameTf.setText(selected.getName());
				this.addressTf.setText(selected.getAddress());
				this.postalCodeTf.setText(selected.getPostalCode());
				this.cityCombo.getSelectionModel().select(selected.getCity());
			}
		});

		// Create the buttons and add them to the HBox
		this.update = new Button("Update");
		this.delete = new Button("Delete");

		this.buttons = new HBox();
		this.buttons.getChildren().addAll(this.update, this.delete);
		this.buttons.setAlignment(Pos.CENTER);
		this.buttons.setSpacing(50);




		// Button Event Handlers

		this.update.setOnAction(e->{
			Location selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				selected.setName(this.nameTf.getText());
				selected.setAddress(this.addressTf.getText());
				selected.setPostalCode(this.postalCodeTf.getText());
				selected.setCity(this.cityCombo.getSelectionModel().getSelectedItem());

				this.locationTable.updateLocation(selected);
				this.locations.removeAll(this.locations);
				this.locations = this.locationTable.getAllLocations();
				this.table.setItems(FXCollections.observableArrayList(this.locations));
				this.table.getSelectionModel().select(selected);
			} else {
				System.out.println("Nothing was selected!");
			}
		});

		this.root = new BorderPane();
		this.root.setTop(this.table);
		this.root.setCenter(this.locationInfo);
		this.root.setBottom(this.buttons);

		// Styling
		this.locationInfo.setHgap(25);
		this.locationInfo.setVgap(10);
		this.locationInfo.setPadding(new Insets(10,10,10,10));
		this.locationInfo.setAlignment(Pos.TOP_CENTER);

		BorderPane.setAlignment(this.locationInfo, Pos.CENTER);
		BorderPane.setAlignment(this.buttons, Pos.TOP_CENTER);
		BorderPane.setMargin(this.buttons, new Insets(50,50,50,50));
		BorderPane.setMargin(this.table, new Insets(10,10,10,10));

		this.setContent(root);

	}
	public static ViewLocationTab getInstance() {
		if(instance == null) {
			instance = new ViewLocationTab();
			return instance;
		} else {
			return instance;
		}

	}

}
