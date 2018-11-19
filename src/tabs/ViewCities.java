package tabs;

import java.util.ArrayList;
import java.util.Date;

import database.Database;
import javabeans.CityTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import tables.City;

public class ViewCities extends Tab {
	Database db = Database.getInstance();
	CityTable CityTable;
	ArrayList<City> citys;
	City city;	

	public static ViewCities instance = null;
	private Button refresh;
	private TableView<City> table;
	private TableColumn<City, Integer> idCol;
	private TableColumn<City, String> cityCol;
	

	private BorderPane root;


	public ViewCities() {
		this.CityTable = new CityTable();
		this.Citys = new ArrayList<>();
		this.Citys = this.CityTable.getAllCities();

		this.setText("View Citys");


		this.idCol = new TableColumn<>();
		this.idCol.setText("ID");

		this.cityCol = new TableColumn<>();
		this.cityCol.setText("City");



		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.Citys));


		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));
		


		table.getColumns().setAll(this.idCol, this.cityCol);


		this.refresh = new Button("Refresh");
		this.refresh.setOnAction(e->{
			this.citys.removeAll(this.citys);
			this.citys = this.managerTable.getAllCitys();
			this.table.setItems(FXCollections.observableArrayList(this.citys));
			System.out.println("Table Refreshed");
		});


		this.root = new BorderPane();
		this.root.setCenter(this.table);
		this.root.setBottom(this.refresh);

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
