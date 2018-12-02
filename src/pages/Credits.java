package pages;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.Main;

public class Credits {

	public MainMenu mainMenu;

	private Text devText;
	private Text name1;
	private Text name2;
	private Text name3;
	private Text name4;

	private Text title;
	private Text logo;
	private Text font;

	private Text email1; 
	private Text email2; 
	private Text email3; 
	private Text email4; 


	private Scene scene;
	private GridPane pane;
	private BorderPane root;
	private VBox developersBox;
	private VBox emailBox;
	private VBox infoBox;

	private Image logoImg;

	private ImageView logoIV;


	private Button menuButton;

	public Credits(){
		
		this.devText = new Text("Developers");
		this.name1 = new Text ("Jonathon Bauer");
		this.name2 = new Text ("Cody Pollard");
		this.name3 = new Text ("Joseph Bumbacco");
		this.name4 = new Text ("Grant Norris");

		this.title = new Text ("Fit4Life");

		this.email1 = new Text ("jonathon.bauer01@stclairconnect.ca");
		this.email2 = new Text ("cody.pollard01@stclairconnect.ca");
		this.email3 = new Text ("joseph.bumbacco01@stclairconnect.ca");
		this.email4 = new Text ("grant.norris01@stclairconnect.ca");

		// Logo
		logoImg = new Image("main/fit4lifelogo.png");
		this.logoIV = new ImageView(logoImg);
		this.logoIV.setFitHeight(250);	
		this.logoIV.setFitWidth(250);


		this.logo = new Text ("Logo Created By: Cody Pollard");
		this.font = new Text ("Font Used: Verdana");

		//This HBox Holds The information of Cody, Jonny, Joe & Grant
		this.developersBox = new VBox();
		this.developersBox.getChildren().addAll(name1, name2, name3, name4);
		this.developersBox.setSpacing(10);
		this.developersBox.setAlignment(Pos.CENTER);

		//This HBox Holds the Email of Cody, Jonny, & Joe, Grant
		this.emailBox = new VBox();
		this.emailBox.getChildren().addAll(this.email1, this.email2, this.email3, this.email4);
		this.emailBox.setSpacing(10);
		this.emailBox.setAlignment(Pos.CENTER);

		//This VBox Holds the information of the font,logo,images
		this.infoBox = new VBox();
		this.infoBox.getChildren().addAll(this.logoIV, this.logo, this.font, this.devText);
		this.infoBox.setSpacing(10);
		this.infoBox.setAlignment(Pos.TOP_CENTER);

		//This button will send you to the main menu
		this.menuButton = new Button("Main Menu");
		this.menuButton.setAlignment(Pos.CENTER);

		//Button functionality
		this.mainMenu = new MainMenu();
		this.menuButton.setOnAction(e->{
			Main.mainStage.setScene(mainMenu.getScene());
		});

		//Create The Gridpane
		this.pane = new GridPane();

		

		//Setting all of the information onto the screen
		this.pane.add(this.infoBox, 1, 1, 2, 1);
		this.pane.add(this.developersBox, 1, 2, 1, 1);
		this.pane.add(this.emailBox, 2, 2, 1, 1);
		this.pane.add(this.menuButton, 1, 3, 2, 1);
		

		GridPane.setHalignment(this.menuButton, HPos.CENTER);
		this.pane.setAlignment(Pos.CENTER);
		this.pane.setVgap(25);
		
		this.root = new BorderPane();

		menuBar menuBar = new menuBar();

		this.root.setTop(menuBar);
		this.root.setCenter(this.pane);
//		this.root.setBottom(this.menuButton);


//		BorderPane.setMargin(this.menuButton, new Insets(0,0,25,0));

		this.scene = new Scene(this.root, 1024, 768);
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

	public VBox getDevelopersBox() {
		return developersBox;
	}

	public void setDevelopersBox(VBox developersBox) {
		this.developersBox = developersBox;
	}

	public VBox getEmailBox() {
		return emailBox;
	}

	public void setEmailBox(VBox emailBox) {
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

