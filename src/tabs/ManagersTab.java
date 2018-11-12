package tabs;

public class ManagersTab extends TabTemplate {
	public static ManagersTab instance = null;
	
	private ManagersTab() {
		this.setText("Managers");
		
		this.getCreateButton().setText("Create A New Manager");
		this.getUpdateButton().setText("Update a Manager");
		this.getViewButton().setText("View Managers");
		this.getReportsButton().setText("Manager Reports");
		
	}
	
	public static ManagersTab getInstance() {
		if(instance == null) {
			instance = new ManagersTab();
			return instance;
		} else {
			return instance;
		}
		
	}
}
