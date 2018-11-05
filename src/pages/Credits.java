package pages;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Credits {
	
//	private Text name1;
//	private Text name2;
//	private Text name3;
	
	private Text title;
	private Text logo;
	private Text font;
	private Text image;
	private Text email; 
	
	private HBox developersBox;
	private HBox emailBox;
	private VBox infoBox;
	
	private Button menuButton;
	
	public Credits(){
//	this.name1 = new Text ("Jonny Bauer");
//	this.name2 = new Text ("Cody Pollard");
//	this.name3 = new Text ("Joe B");
	this.title = new Text ("Fit4Life");
	this.email = new Text ("cody@hotmail.com");
	this.image = new Text ("Image Used: NameHere");
	this.logo = new Text ("Logo Created By: NameHere");
	this.font = new Text ("Font Used: NameHere");
	
	//This HBox Holds The information of Cody, Jonny, & Joe
	this.developersBox = new HBox();
	//this.developersBox.getChildren().addAll(name1, name2, name3);
	this.developersBox.setSpacing(5);
	//this.developersBox.setAlignment(Pos.BOTTOM_CENTER);

	//This HBox Holds the Email of Cody, Jonny, & Joe
	this.emailBox = new HBox();
	//this.emailBox.getChildren().addAll(email1, email2, email3);
	this.emailBox.setSpacing(5);
	this.emailBox.setAlignment(Pos.BOTTOM_CENTER);

	//This VBox Holds the information of the font,logo,images
	this.infoBox = new VBox();
	this.infoBox.getChildren().addAll(title, image, logo, font);
	this.infoBox.setSpacing(5);
	this.infoBox.setAlignment(Pos.CENTER);

	//This button will send you to the main menu
	this.menuButton = new Button("Main Menu");
	this.menuButton.setAlignment(Pos.BOTTOM_RIGHT);
}
//	public Text getName1() {
//		return name1;
//	}
//
//	public void setName1(Text name1) {
//		this.name1 = name1;
//	}
//
//	public Text getName2() {
//		return name2;
//	}
//
//	public void setName2(Text name2) {
//		this.name2 = name2;
//	}
//
//	public Text getName3() {
//		return name3;
//	}
//
//	public void setName3(Text name3) {
//		this.name3 = name3;
//	}

	public Text getTitle() {
		return title;
	}

	public void setTitle(Text title) {
		this.title = title;
	}

	public Text getLogo() {
		return logo;
	}

	public void setLogo(Text logo) {
		this.logo = logo;
	}

	public Text getFont() {
		return font;
	}

	public void setFont(Text font) {
		this.font = font;
	}

	public Text getImage() {
		return image;
	}

	public void setImage(Text image) {
		this.image = image;
	}

	public Text getEmail() {
		return email;
	}

	public void setEmail(Text email) {
		this.email = email;
	}

}

