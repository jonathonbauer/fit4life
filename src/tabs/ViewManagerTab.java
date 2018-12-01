package tabs;

import java.util.ArrayList;
import java.util.Optional;

import database.Database;
import javabeans.CityTable;
import javabeans.ManagerTable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import tables.Manager;

public class ViewManagerTab extends Tab {
	Database db = Database.getInstance();
	ManagerTable managerTable;
	CityTable cityTable;
	ArrayList<Manager> managers;
	Manager manager;	

	public static ViewManagerTab instance = null;
	private TableView<Manager> table;
	private TableColumn<Manager, Integer> idCol;
	private TableColumn<Manager, String> fnameCol;
	private TableColumn<Manager, String> lnameCol;
	private TableColumn<Manager, String> addressCol;
	private TableColumn<Manager, String> postalCodeCol;
	private TableColumn<Manager, String> cityCol;
	
	private GridPane locationInfo;

	private Text id;
	private Text managerId;

	private Text fname;
	private TextField fnameTf;

	private Text lname;
	private TextField lnameTf;

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


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ViewManagerTab() {
		this.managerTable = new ManagerTable();
		this.managers = new ArrayList<>();
		this.managers = this.managerTable.getAllManagers();

		this.setText("All Managers");


		this.idCol = new TableColumn<>();
		this.idCol.setText("ID");

		this.fnameCol = new TableColumn<>();
		this.fnameCol.setText("First Name");

		this.lnameCol = new TableColumn<>();
		this.lnameCol.setText("Last Name");

		this.addressCol = new TableColumn<>();
		this.addressCol.setText("Address");

		this.postalCodeCol = new TableColumn<>();
		this.postalCodeCol.setText("Postal Code");

		this.cityCol = new TableColumn<>();
		this.cityCol.setText("City");

		


		this.table = new TableView<>();
		this.table.setItems(FXCollections.observableArrayList(this.managers));
		this.table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
		this.fnameCol.setCellValueFactory(new PropertyValueFactory("fname"));
		this.lnameCol.setCellValueFactory(new PropertyValueFactory("lname"));
		this.addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		this.postalCodeCol.setCellValueFactory(new PropertyValueFactory("postalCode"));
		this.cityCol.setCellValueFactory(new PropertyValueFactory("city"));
		


		TableColumn<Manager, String> firstNameCol = new TableColumn<Manager,String>("Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));


		TableColumn<Manager,String> lastNameCol = new TableColumn<Manager,String>("Address");
		lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

		table.getColumns().setAll(this.idCol, this.fnameCol, this.lnameCol, this.addressCol, this.postalCodeCol, this.cityCol);


		// Information Beneath Table
				this.locationInfo = new GridPane();

				this.id = new Text("Manager ID");
				this.managerId = new Text("0");

				this.fname = new Text("First Name:");
				this.fnameTf = new TextField();

				this.lname = new Text("Last Name:");
				this.lnameTf = new TextField();

				this.address = new Text("Address");
				this.addressTf = new TextField();

				this.postalCode = new Text("Postal Code");
				this.postalCodeTf = new TextField();

				this.cityTable = new CityTable();
				this.city = new Text("City");
				this.cityCombo = new ComboBox(FXCollections.observableArrayList(this.cityTable.getAllCityNames()));	
				
				
				// Add the nodes to the GridPane
				this.locationInfo.add(this.id, 0, 0);
				this.locationInfo.add(this.managerId, 1, 0);
				this.locationInfo.add(this.fname, 0, 1);
				this.locationInfo.add(this.fnameTf, 1, 1);
				this.locationInfo.add(this.lname, 0, 2);
				this.locationInfo.add(this.lnameTf, 1, 2);
				
				
				this.locationInfo.add(this.address, 2, 0);
				this.locationInfo.add(this.addressTf, 3, 0);
				this.locationInfo.add(this.city, 2, 1);
				this.locationInfo.add(this.cityCombo, 3, 1);
				this.locationInfo.add(this.postalCode, 2, 2);
				this.locationInfo.add(this.postalCodeTf, 3, 2);	
				
				
				// Set the values when a user is selected
				this.table.getSelectionModel().selectedItemProperty().addListener(e->{
					Manager selected = this.table.getSelectionModel().getSelectedItem();
					if(selected != null) {
						this.managerId.setText(selected.getId() + "");
						this.fnameTf.setText(selected.getFname());
						this.lnameTf.setText(selected.getLname());
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
					Manager selected = this.table.getSelectionModel().getSelectedItem();
					if(selected != null) {
						selected.setFname(this.fnameTf.getText());
						selected.setLname(this.lnameTf.getText());
						selected.setAddress(this.addressTf.getText());
						selected.setPostalCode(this.postalCodeTf.getText());
						selected.setCity(this.cityCombo.getSelectionModel().getSelectedItem());

						this.managerTable.updateManager(selected);
						this.managers.removeAll(this.managers);
						this.managers = this.managerTable.getAllManagers();
						this.table.setItems(FXCollections.observableArrayList(this.managers));
						this.table.getSelectionModel().select(selected);
					} else {
						System.out.println("Nothing was selected!");
					}
				});

				this.delete.setOnAction(e -> {
					Manager selected = this.table.getSelectionModel().getSelectedItem();
					if (selected != null) {
						selected.setFname(this.fnameTf.getText());
						selected.setLname(this.lnameTf.getText());
						selected.setAddress(this.addressTf.getText());
						selected.setPostalCode(this.postalCodeTf.getText());
						selected.setCity(this.cityCombo.getSelectionModel().getSelectedItem());

						Alert confirmation = new Alert(AlertType.CONFIRMATION);
						confirmation.setHeaderText(null);
						confirmation.setTitle("Confirm Deletion");
						confirmation.setContentText("Are you sure you wish to delete the manager " + selected.getFname() + " " + selected.getLname() + "?");
						
						Optional<ButtonType> confirmResult = confirmation.showAndWait();
						if(confirmResult.get() == ButtonType.OK) {
							this.managerTable.deleteManager(selected);
							this.managers.removeAll(this.managers);
							this.managers = this.managerTable.getAllManagers();
							this.table.setItems(FXCollections.observableArrayList(this.managers));
							this.table.getSelectionModel().select(0);
						} else {
							System.out.println("Nothing deleted");
						}
						
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

	public static ViewManagerTab getInstance() {
		if(instance == null) {
			instance = new ViewManagerTab();
			return instance;
		} else {
			return instance;
		}

	}

}
