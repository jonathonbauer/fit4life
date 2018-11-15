package tabs;

public class ManagersTab extends TabTemplate {
	public static ManagersTab instance = null;
	
	private ManagersTab() {
		this.setText("Managers");
		
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
