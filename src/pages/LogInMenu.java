package pages;


import java.util.ArrayList;

import javabeans.UserTable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Main;
import main.Session;
import tables.User;

public class LogInMenu {
	
	
	public MainMenu mainMenu;
	
	private BorderPane pane;
	private Scene scene;
	
	private VBox top;
	private VBox bottom;
	private VBox middle;
	private VBox baseline;
	
	private TextField userName;
	private PasswordField passWord;
	
	private Font titleFont;
	
	private Text title;
	private Text errorText;
	
	private Button login;
	
	private CheckBox remember;
	
	private Image logo;
	
	private ImageView logoIV;
	
	public LogInMenu() {
		
		/*
		 * This section of the code is what will run after the program has launched and has no existing profiles logged in.
		 * it will prompt the user for their user name and password and attempt to log them into the database.
		 */ 

		
		//BorderPane initialization
		this.pane = new BorderPane();
		
		//Creating VBox's for positioning TextFields
		this.top = new VBox();
		this.top.setAlignment(Pos.CENTER);
	
		this.bottom = new VBox();
		this.bottom.setAlignment(Pos.BOTTOM_CENTER);
		
		this.middle = new VBox();
		this.middle.setAlignment(Pos.CENTER);
		
		this.baseline = new VBox();
		this.baseline.setAlignment(Pos.BASELINE_CENTER);
		
		//Adding in a new font
		this.titleFont = Font.font("Century Gothic", FontWeight.BOLD, FontPosture.REGULAR, 40);
		
		// Logo
		this.logo = new Image("main/fit4lifelogo.png");
		this.logoIV = new ImageView(logo);
		this.logoIV.setFitHeight(250);
		this.logoIV.setFitWidth(250);
				
		// Logo Animation
		Main.logoAnimate(logoIV);
		
		//Error Text
		this.errorText = new Text();
		
		
		//Adding in Button Nodes
		
		this.login = new Button("Log In");
		
		//Adding in CheckBox Nodes
//		this.remember = new CheckBox("Remember me?");
		
		//Setting default checkbox values
//		this.remember.setIndeterminate(false);
		
		//Adding in TextField and PasswordField to store username and password
		
		this.userName = new TextField();
		this.userName.setMaxHeight(30);
		this.userName.setMinHeight(30);
 		this.userName.setMaxWidth(300);
		this.userName.setPromptText("USERNAME");
		
		this.passWord = new PasswordField();
		this.passWord.setMinHeight(30);
		this.passWord.setMaxHeight(30);
		this.passWord.setMaxWidth(300);
		this.passWord.setPromptText("PASSWORD");
		
		
		/*
		 * login Button Event Handler
		 * 
		 */
		
		this.login.setOnAction(e->{
			
				//Get the users from the database
				UserTable userTable = new UserTable();
				ArrayList<User> users = new ArrayList<>();
				users = userTable.getAllUsers();
				
				
//				for(int i = 0; i < users.size(); i++) {
//					if(this.userName.getText().equals(users.get(i).getUsername())) {
//						if(this.passWord.getText().equals(users.get(i).getPassword())) {
//							System.out.println("Successful login.");
//				
//							Session.getInstance().setLoggedInUser(new User(users.get(i).getUsername(), users.get(i).getPassword()));
//							
//							mainMenu = new MainMenu();
//							Main.mainStage.setScene(mainMenu.getScene());
//							Main.mainStage.setTitle("Fit4Life Member Management");
//						} else {
//							System.out.println("Incorrect Password");
//						}
//					} 					
//				}

			Session.getInstance().setLoggedInUser(new User(users.get(0).getUsername(), users.get(0).getPassword()));
			mainMenu = new MainMenu();
			Main.mainStage.setScene(mainMenu.getScene());
			Main.mainStage.setTitle("Fit4Life Member Management");
		
		
		});
		
	
		/*
		 * Adding the userName and passWord TextArea fields to the "Middle" VBox
		 */
		
		//this.top.getChildren().add(logoIV);
		
		this.middle.getChildren().addAll(logoIV, userName, passWord,/*remember,*/ errorText, login);
		
		//this.bottom.getChildren().add(login);
		
		this.pane.setTop(top);
		this.pane.setBottom(bottom);		
		this.pane.setCenter(middle);

		this.scene = new Scene(this.pane, 1024, 768);
		
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public BorderPane getPane() {
		return pane;
	}

	public void setPane(BorderPane pane) {
		this.pane = pane;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public VBox getTop() {
		return top;
	}

	public void setTop(VBox top) {
		this.top = top;
	}

	public VBox getBottom() {
		return bottom;
	}

	public void setBottom(VBox bottom) {
		this.bottom = bottom;
	}

	public VBox getMiddle() {
		return middle;
	}

	public void setMiddle(VBox middle) {
		this.middle = middle;
	}

	public VBox getBaseline() {
		return baseline;
	}

	public void setBaseline(VBox baseline) {
		this.baseline = baseline;
	}

	public TextField getUserName() {
		return userName;
	}

	public void setUserName(TextField userName) {
		this.userName = userName;
	}

	public PasswordField getPassWord() {
		return passWord;
	}

	public void setPassWord(PasswordField passWord) {
		this.passWord = passWord;
	}

	public Font getTitleFont() {
		return titleFont;
	}

	public void setTitleFont(Font titleFont) {
		this.titleFont = titleFont;
	}

	public Text getTitle() {
		return title;
	}

	public void setTitle(Text title) {
		this.title = title;
	}

	public Text getErrorText() {
		return errorText;
	}

	public void setErrorText(Text errorText) {
		this.errorText = errorText;
	}

	public Button getLogin() {
		return login;
	}

	public void setLogin(Button login) {
		this.login = login;
	}

	public CheckBox getRemember() {
		return remember;
	}

	public void setRemember(CheckBox remember) {
		this.remember = remember;
	}

}

    	