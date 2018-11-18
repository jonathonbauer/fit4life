package tabs;

import java.util.ArrayList;

import database.Database;
import javabeans.MemberTable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tables.Member;

public class CreateMemberTab extends Tab {
	Database db = Database.getInstance();
	MemberTable memberTable;
	ArrayList<Member> members;
	Member member;	

	public static CreateMemberTab instance = null;

	private BorderPane root;


	public CreateMemberTab() {
		this.memberTable = new MemberTable();
		this.members = new ArrayList<>();
		this.members = this.memberTable.getAllMembers();

		this.setText("Create A Member");


		


		this.root = new BorderPane();

		this.setContent(root);
	}

	public static CreateMemberTab getInstance() {
		if(instance == null) {
			instance = new CreateMemberTab();
			return instance;
		} else {
			return instance;
		}

	}

}
