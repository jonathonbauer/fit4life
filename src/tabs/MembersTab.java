package tabs;

public class MembersTab extends TabTemplate {
	public static MembersTab instance = null;
	
	private MembersTab() {
		this.setText("Members");
		
		this.getCreateButton().setText("Create A New Member");
		this.getUpdateButton().setText("Update a Member");
		this.getViewButton().setText("View Members");
		this.getReportsButton().setText("Member Reports");
		
	}
	
	public static MembersTab getInstance() {
		if(instance == null) {
			instance = new MembersTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}