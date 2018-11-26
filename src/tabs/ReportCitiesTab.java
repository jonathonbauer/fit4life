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

public class ReportCitiesTab extends Tab {
	Database db = Database.getInstance();
	CityTable cityTable;
	ArrayList<City> cities;
	City city;	
	
	MemberTable memberTable;
	ArrayList<Member> members;
	Member member;	


	public static ReportCitiesTab instance = null;
	
//	private TableView<Location> table;
//	private BarChart<Location, Integer> idCol;
//	private TableColumn<Location, String> nameCol;
//	private BarChart<Location, String> addressCol;

	private BorderPane root;
	
	public ReportCitiesTab() {
		
		//Gets each City and puts it into an arraylist
		this.cityTable = new CityTable();
		//this.locations = ArrayList<>();
		this.cities = this.cityTable.getAllCities();
		
		//gets each member and puts it into an arraylist
		this.memberTable = new MemberTable();
		this.members = new ArrayList<>();
		this.members = this.memberTable.getAllMembers();
		
		//Creating the bar graph and setting labels
		this.setText("City Report");
		CategoryAxis XAxis = new CategoryAxis();
		NumberAxis YAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(XAxis, YAxis);
		XAxis.setLabel("City");
		YAxis.setLabel("Members");
		
		
		//Managers here
		
		//Getting the info to the Chart
		XYChart.Series chart = new XYChart.Series<>();
		for(int i = 0; i < this.cities.size(); i++) {
		chart.getData().add(new XYChart.Data(this.cities.get(i).getCity(), 
				this.memberTable.getMemberLocation(this.cities.get(i).getId()).size()));
		}
		barChart.getData().add(chart);

		//Displaying the info on the screen
		root = new BorderPane();
		this.root.setCenter(barChart);
		this.setContent(root);

	}
	public static ReportCitiesTab getInstance() {
		if(instance == null) {
			instance = new ReportCitiesTab();
			return instance;
		} else {
			return instance;
		}
	}
}

