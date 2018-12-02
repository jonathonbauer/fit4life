package pages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Credits {
	
	public MainMenu mainMenu;
	
	private Text name1;
	private Text name2;
	private Text name3;
	private Text name4;
	
	private Text title;
	private Text logo;
	private Text font;
	private Text image;
	
	private Text email1; 
	private Text email2; 
	private Text email3; 
	private Text email4; 
	
	
	private Scene scene;
	private GridPane pane;
	private HBox developersBox;
	private HBox emailBox;
	private VBox infoBox;
	
	private Button menuButton;
	
	public Credits(){
	this.name1 = new Text ("Jonny Bauer");
	this.name2 = new Text ("Cody Pollard");
	this.name3 = new Text ("Joe B");
	this.name4 = new Text ("Grant");
	
	this.title = new Text ("Fit4Life");
	
	this.email1 = new Text ("jonny@hotmail.com");
	this.email2 = new Text ("cody@hotmail.com");
	this.email3 = new Text ("joe@hotmail.com");
	this.email4 = new Text ("grant@hotmail.com");
	
	this.image = new Text ("Image Used: NameHere");
	this.logo = new Text ("Logo Created By: NameHere");
	this.font = new Text ("Font Used: NameHere");
	
	//This HBox Holds The information of Cody, Jonny, Joe & Grant
	this.developersBox = new HBox();
	this.developersBox.getChildren().addAll(name1, name2, name3, name4);
	this.developersBox.setSpacing(5);
	this.developersBox.setAlignment(Pos.CENTER);

	//This HBox Holds the Email of Cody, Jonny, & Joe, Grant
	this.emailBox = new HBox();
	this.emailBox.getChildren().addAll(this.email1, this.email2, this.email3, this.email4);
	this.emailBox.setSpacing(5);
	this.emailBox.setAlignment(Pos.CENTER);

	//This VBox Holds the information of the font,logo,images
	this.infoBox = new VBox();
	this.infoBox.getChildren().addAll(this.title, this.image, this.logo, this.font);
	this.infoBox.setSpacing(5);
	this.infoBox.setAlignment(Pos.CENTER);

	//This button will send you to the main menu
	this.menuButton = new Button("Main Menu");
	this.menuButton.setAlignment(Pos.BOTTOM_RIGHT);
	
	//Button functionality
//	this.mainMenu = new MainMenu();
//	this.menuButton.setOnAction(e->{
//	Main.mainStage.setScene(mainMenu.getScene());
//	});
	
	//Create The Gridpane
	this.pane = new GridPane();
	//this.pane.setGridLinesVisible(true);
	
	this.pane.setAlignment(Pos.CENTER);
	//Setting all of the information onto the screen
	this.pane.add(this.infoBox, 1, 1, 1, 1);
	this.pane.add(this.developersBox, 1, 2, 1, 1);
	this.pane.add(this.emailBox, 1, 3, 1, 1);
	this.pane.add(this.menuButton, 1, 4, 1, 1);
	this.scene = new Scene(this.pane, 1024, 768);
	this.scene.getStylesheets().add("style/style.css");
	
	
}
	
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public HBox getDevelopersBox() {
		return developersBox;
	}

	public void setDevelopersBox(HBox developersBox) {
		this.developersBox = developersBox;
	}

	public HBox getEmailBox() {
		return emailBox;
	}

	public void setEmailBox(HBox emailBox) {
		this.emailBox = emailBox;
	}

	public VBox getInfoBox() {
		return infoBox;
	}

	public void setInfoBox(VBox infoBox) {
		this.infoBox = infoBox;
	}

	public Button getMenuButton() {
		return menuButton;
	}

	public void setMenuButton(Button menuButton) {
		this.menuButton = menuButton;
	}

	public Text getName1() {
		return name1;
	}

	public void setName1(Text name1) {
		this.name1 = name1;
	}

	public Text getName2() {
		return name2;
	}

	public void setName2(Text name2) {
		this.name2 = name2;
	}

	public Text getName3() {
		return name3;
	}

	public void setName3(Text name3) {
		this.name3 = name3;
	}
	public Text getName4() {
		return name4;
	}

	public void setName4(Text name4) {
		this.name4 = name4;
	}

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

	public Text getEmail1() {
		return email1;
	}

	public void setEmail1(Text email1) {
		this.email1 = email1;
	}

	public Text getEmail2() {
		return email2;
	}

	public void setEmail2(Text email2) {
		this.email2 = email2;
	}

	public Text getEmail3() {
		return email3;
	}

	public void setEmail3(Text email3) {
		this.email3 = email3;
	}

	public Text getEmail4() {
		return email4;
	}

	public void setEmail4(Text email4) {
		this.email4 = email4;
	}
	
}

