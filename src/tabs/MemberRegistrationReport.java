package tabs;


import java.util.ArrayList;

import database.Database;
import javabeans.CityTable;

import javabeans.MemberTable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tables.City;
import tables.Member;

public class MemberRegistrationReport extends Tab {
	Database db = Database.getInstance();
	CityTable CityTable;
	ArrayList<City> cities;
	City city;	
	
	MemberTable memberTable;
	ArrayList<Member> members;
	Member member;	


	public static MemberRegistrationReport instance = null;
	
//	private TableView<Location> table;
//	private BarChart<Location, Integer> idCol;
//	private TableColumn<Location, String> nameCol;
//	private BarChart<Location, String> addressCol;

	private BorderPane root;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MemberRegistrationReport() {
		
		//Gets each Location and puts it into an arraylist
		this.CityTable = new CityTable();
		//this.locations = ArrayList<>();
		this.cities = this.CityTable.getAllCities();
		
		//gets each member and puts it into an arraylist
		this.memberTable = new MemberTable();
		this.members = new ArrayList<>();
		this.members = this.memberTable.getAllMembers();
		
		//Creating the bar graph and setting labels
		this.setText("Registration Report");
		CategoryAxis XAxis = new CategoryAxis();
		NumberAxis YAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(XAxis, YAxis);
		XAxis.setLabel("Cities");
		YAxis.setLabel("Members Per City");
		
		//Getting the info to the Chart
		XYChart.Series chart = new XYChart.Series<>();
		chart.getData().add(new XYChart.Data(this.cities, this.members));

		//Displaying the info on the screen
		root = new BorderPane();
		this.root.setCenter(barChart);
		this.setContent(root);
		
		
	}

	public static MemberRegistrationReport getInstance() {
		if(instance == null) {
			instance = new MemberRegistrationReport();
			return instance;
		} else {
			return instance;
		}
		
	
	}
}
