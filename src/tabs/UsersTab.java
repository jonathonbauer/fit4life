package tabs;

public class UsersTab extends TabTemplate {
	public static UsersTab instance = null;
	
	private UsersTab() {
		this.setText("Users");
		
		this.getCreateButton().setText("Create A New User");
		this.getUpdateButton().setText("Update a User");
		this.getViewButton().setText("View Users");
		this.getReportsButton().setText("User Reports");
		
	}
	
	public static UsersTab getInstance() {
		if(instance == null) {
			instance = new UsersTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}