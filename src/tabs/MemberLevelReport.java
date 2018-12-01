package tabs;
import java.util.ArrayList;

import database.Database;
import javabeans.MemberLevelTable;

import javabeans.MemberTable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tables.Member;
import tables.MemberLevel;
public class MemberLevelReport extends Tab {


	
		Database db = Database.getInstance();	
		MemberLevelTable memberLevelTable;
		ArrayList<MemberLevel> memberLevels;
		MemberLevel memberLevel;	
		
		MemberTable memberTable;
		ArrayList<Member> members;
		Member member;	


		public static MemberLevelReport instance = null;
		


		private BorderPane root;
		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public MemberLevelReport() {
			
			//gets each member and puts it into an arraylist
			this.memberTable = new MemberTable();
			this.members = new ArrayList<>();
			this.members = this.memberTable.getAllMembers();
			
			//get all member levels and put it into an array list
			this.memberLevelTable = new MemberLevelTable();
			this.memberLevels = new ArrayList<>();
			this.memberLevels = this.memberLevelTable.getAllMemberLevels();
			
			//Creating the bar graph and setting labels
			this.setText("Member Level Report");
			CategoryAxis XAxis = new CategoryAxis();
			NumberAxis YAxis = new NumberAxis();
			BarChart<String, Number> barChart = new BarChart<String, Number>(XAxis, YAxis);
			XAxis.setLabel("member Level");
			YAxis.setLabel("Members per level");
			
			//Getting the info to the Chart
			XYChart.Series chart = new XYChart.Series<>();
			chart.getData().add(new XYChart.Data(this.memberLevels, this.members));

			//Displaying the info on the screen
			root = new BorderPane();
			this.root.setCenter(barChart);
			this.setContent(root);
			
			
		}

		public static MemberLevelReport getInstance() {
			if(instance == null) {
				instance = new MemberLevelReport();
				return instance;
			} else {
				return instance;
			}
			
		
		}
	}



