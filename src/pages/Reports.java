package pages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Reports {
	
	private Button locationReport;
	private Button cityReport;
	private Button membershipReport;
	private Button registrationReport;
	
	private VBox reportButtonBox;
	
	private Scene scene;

	public Reports() {
		this.locationReport = new Button("Location Report");
		this.cityReport = new Button("City Report");
		this.membershipReport = new Button("Membership Report");
		this.registrationReport = new Button("Registration Report");
		
		this.locationReport.setMinSize(750,  100);
		this.cityReport.setMinSize(750,  100);
		this.membershipReport.setMinSize(750,  100);
		this.registrationReport.setMinSize(750,  100);
		
		this.reportButtonBox = new VBox();
		this.reportButtonBox.getChildren().addAll(locationReport, cityReport, membershipReport, registrationReport);
		this.reportButtonBox.setSpacing(5);
		this.reportButtonBox.setAlignment(Pos.CENTER);
		
		this.scene = new Scene(this.reportButtonBox, 1024, 768);
		this.scene.getStylesheets().add("style/style.css");
	}
	

	public Scene getScene() {
		return scene;
	}


	public void setScene(Scene scene) {
		this.scene = scene;
	}


	public Button getLocationReport() {
		return locationReport;
	}

	public void setLocationReport(Button locationReport) {
		this.locationReport = locationReport;
	}

	public Button getCityReport() {
		return cityReport;
	}

	public void setCityReport(Button cityReport) {
		this.cityReport = cityReport;
	}

	public Button getMembershipReport() {
		return membershipReport;
	}

	public void setMembershipReport(Button membershipReport) {
		this.membershipReport = membershipReport;
	}

	public Button getRegistrationReport() {
		return registrationReport;
	}

	public void setRegistrationReport(Button registrationReport) {
		this.registrationReport = registrationReport;
	}

	public VBox getReportButtonBox() {
		return reportButtonBox;
	}

	public void setReportButtonBox(VBox reportButtonBox) {
		this.reportButtonBox = reportButtonBox;
	}


}
