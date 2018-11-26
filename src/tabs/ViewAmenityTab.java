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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
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

	private GridPane amenityInfo;

	private Text id;
	private Text amenityId;

	private Text name;
	private TextField nameTf;

	private Button update;
	private Button delete;

	private HBox buttons;
	private BorderPane root;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ViewAmenityTab() {

		//Get All Amenities from the Table
		this.amenityTable = new AmenityTable();
		//this.amenities = ArrayList<>();
		this.amenities = this.amenityTable.getAllAmenities();

		this.setText("View Amenities");

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

		// Information Beneath Table
		this.amenityInfo = new GridPane();

		this.id = new Text("ID");
		this.amenityId = new Text("0");

		this.name = new Text("Amenity");
		this.nameTf = new TextField();

		// Add the nodes to the GridPane
		this.amenityInfo.add(this.id, 1, 0);
		this.amenityInfo.add(this.amenityId, 2, 0);
		this.amenityInfo.add(this.name, 1, 1);
		this.amenityInfo.add(this.nameTf, 2, 1);



		// Set the values when a user is selected
		this.table.getSelectionModel().selectedItemProperty().addListener(e->{
			Amenity selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				this.amenityId.setText(selected.getId() + "");
				this.nameTf.setText(selected.getAmenity());
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
			Amenity selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				selected.setAmenity(this.nameTf.getText());

				this.amenityTable.updateAmenity(selected);
				this.amenities.removeAll(this.amenities);
				this.amenities = this.amenityTable.getAllAmenities();
				this.table.setItems(FXCollections.observableArrayList(this.amenities));
				this.table.getSelectionModel().select(selected);
			} else {
				System.out.println("Nothing was selected!");
			}
		});

		this.root = new BorderPane();
		this.root.setTop(this.table);
		this.root.setCenter(this.amenityInfo);
		this.root.setBottom(this.buttons);

		// Styling
		this.amenityInfo.setHgap(25);
		this.amenityInfo.setVgap(10);
		this.amenityInfo.setPadding(new Insets(10,10,10,10));
		this.amenityInfo.setAlignment(Pos.TOP_CENTER);

		BorderPane.setAlignment(this.amenityInfo, Pos.CENTER);
		BorderPane.setAlignment(this.buttons, Pos.TOP_CENTER);
		BorderPane.setMargin(this.buttons, new Insets(50,50,50,50));
		BorderPane.setMargin(this.table, new Insets(10,10,10,10));

		this.root.setPadding(new Insets(10,10,10,10));

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


