package pages;

import javafx.scene.control.Button;

public class Reports {
	private Button locationReport;
	private Button cityReport;
	private Button membershipReport;
	private Button registrationReport;
	
	
	
	public Reports() {
		this.locationReport = new Button("Location Report");
		this.cityReport = new Button("City Report");
		this.membershipReport = new Button("Membership Report");
		this.registrationReport = new Button("Registration Report");
	}

}
