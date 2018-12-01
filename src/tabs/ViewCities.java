package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;
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
import tables.City;

public class ViewCities extends Tab {
	Database db = Database.getInstance();
	CityTable cityTable;
	ArrayList<City> cities;
	City city;	

	public static ViewCities instance = null;
	private TableView<City> table;
	private TableColumn<City, Integer> idCol;
	private TableColumn<City, String> cityCol;


	private BorderPane root;

	private GridPane cityInfo;

	private Text id;
	private Text cityId;

	private Text name;
	private TextField nameTf;

	private Button update;
	private Button delete;

	private HBox buttons;	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ViewCities() {
		this.cityTable = new CityTable();
		this.cities = new ArrayList<>();
		this.cities = this.cityTable.getAllCities();

		this.setText("All Cities");


		this.idCol = new TableColumn<>();
		this.idCol.setText("ID");

		this.cityCol = new TableColumn<>();
		this.cityCol.setText("City");



		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.cities));


		this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));

		table.getColumns().setAll(this.idCol, this.cityCol);

		// Information Beneath Table
		this.cityInfo = new GridPane();

		this.id = new Text("ID");
		this.cityId = new Text("0");

		this.name = new Text("City");
		this.nameTf = new TextField();

		// Add the nodes to the GridPane
		this.cityInfo.add(this.id, 1, 0);
		this.cityInfo.add(this.cityId, 2, 0);
		this.cityInfo.add(this.name, 1, 1);
		this.cityInfo.add(this.nameTf, 2, 1);

		

		// Set the values when a user is selected
		this.table.getSelectionModel().selectedItemProperty().addListener(e->{
			City selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				this.cityId.setText(selected.getId() + "");
				this.nameTf.setText(selected.getCity());
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
			City selected = this.table.getSelectionModel().getSelectedItem();
			if(selected != null) {
				selected.setCity(this.nameTf.getText());

				this.cityTable.updateCity(selected);
				this.cities.removeAll(this.cities);
				this.cities = this.cityTable.getAllCities();
				this.table.setItems(FXCollections.observableArrayList(this.cities));
				this.table.getSelectionModel().select(selected);
			} else {
				System.out.println("Nothing was selected!");
			}
		});

		this.root = new BorderPane();
		this.root.setTop(this.table);
		this.root.setCenter(this.cityInfo);
		this.root.setBottom(this.buttons);

		// Styling
		this.cityInfo.setHgap(25);
		this.cityInfo.setVgap(10);
		this.cityInfo.setPadding(new Insets(10,10,10,10));
		this.cityInfo.setAlignment(Pos.TOP_CENTER);

		BorderPane.setAlignment(this.cityInfo, Pos.CENTER);
		BorderPane.setAlignment(this.buttons, Pos.TOP_CENTER);
		BorderPane.setMargin(this.buttons, new Insets(50,50,50,50));
		BorderPane.setMargin(this.table, new Insets(10,10,10,10));

		this.root.setPadding(new Insets(10,10,10,10));

		this.setContent(root);
	}

	public static ViewCities getInstance() {
		if(instance == null) {
			instance = new ViewCities();
			return instance;
		} else {
			return instance;
		}

	}

}
