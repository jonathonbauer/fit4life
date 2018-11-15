package tabs;

public class UsersTab extends TabTemplate {
	public static UsersTab instance = null;
	
	private UsersTab() {
		this.setText("Users");

		
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