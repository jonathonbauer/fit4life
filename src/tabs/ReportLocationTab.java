package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.LocationTable;
import javabeans.MemberTable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tables.Location;
import tables.Member;

public class ReportLocationTab extends Tab {
	Database db = Database.getInstance();
	LocationTable locationTable;
	ArrayList<Location> locations;
	Location location;	
	
	MemberTable memberTable;
	ArrayList<Member> members;
	Member member;	


	public static ReportLocationTab instance = null;
	
//	private TableView<Location> table;
//	private BarChart<Location, Integer> idCol;
//	private TableColumn<Location, String> nameCol;
//	private BarChart<Location, String> addressCol;

	private BorderPane root;
	
	
	public ReportLocationTab() {
		
		//Gets each Location and puts it into an arraylist
		this.locationTable = new LocationTable();
		//this.locations = ArrayList<>();
		this.locations = this.locationTable.getAllLocations();
		
		//gets each member and puts it into an arraylist
		this.memberTable = new MemberTable();
		this.members = new ArrayList<>();
		this.members = this.memberTable.getAllMembers();
		
		//Creating the bar graph and setting labels
		this.setText("Location Report");
		CategoryAxis XAxis = new CategoryAxis();
		NumberAxis YAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(XAxis, YAxis);
		XAxis.setLabel("Location");
		YAxis.setLabel("Members");
		
		//Getting the info to the Chart
		XYChart.Series chart = new XYChart.Series<>();
		chart.getData().add(new XYChart.Data(this.locations, this.members));

		//Displaying the info on the screen
		root = new BorderPane();
		this.root.setCenter(barChart);
		this.setContent(root);
		
		
	}

	public static ReportLocationTab getInstance() {
		if(instance == null) {
			instance = new ReportLocationTab();
			return instance;
		} else {
			return instance;
		}
		
	
	}
}
