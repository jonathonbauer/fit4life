package pages;

import javabeans.PasswordTable;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.Main;
import main.Session;
import tables.User;

public class LogInMenu {

	public MainMenu mainMenu;

	private BorderPane pane;
	private Scene scene;

	private VBox top;
	private VBox middle;

	private TextField userName;
	private PasswordField passWord;

	private Font titleFont;

	private Text title;
	private Text errorText;

	private Button login;

	private Image logo;

	private ImageView logoIV;

	public LogInMenu() {

		/*
		 * This section of the code is what will run after the program has launched and
		 * has no existing profiles logged in. it will prompt the user for their user
		 * name and password and attempt to log them into the database.
		 * 
		 * @author  Joe Bumbacco
		 * @since   2018-12-02 
		 */

		// BorderPane initialization
		this.pane = new BorderPane();

		// Creating VBox's for positioning TextFields
		this.top = new VBox();
		this.top.setAlignment(Pos.CENTER);

		this.middle = new VBox();
		this.middle.setAlignment(Pos.TOP_CENTER);

		// Adding in a new font
		this.titleFont = Font.font("Century Gothic", FontWeight.BOLD, FontPosture.REGULAR, 40);

		// Logo
		this.logo = new Image("images/fit4lifelogo.png");
		this.logoIV = new ImageView(logo);
		this.logoIV.setFitHeight(450);
		this.logoIV.setFitWidth(450);
		this.top.getChildren().add(this.logoIV);

		// Logo Animation
		Main.logoAnimate(this.logoIV);

		// Error Text

		this.errorText = new Text();

		// Adding in Button Nodes

		this.login = new Button("Log In");

		// Adding in TextField and PasswordField to store username and password

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

		this.login.setOnAction(e -> {
			// Verify that the users login information is correct
			if (PasswordTable.verifyLogin(this.userName.getText(), this.passWord.getText())) {
				PauseTransition login = new PauseTransition(Duration.seconds(1));

				login.setOnFinished(event -> {
					Session.getInstance().setLoggedInUser(new User(this.userName.getText()));
					mainMenu = new MainMenu();
					Main.mainStage.setScene(mainMenu.getScene());
					Main.mainStage.setTitle("Fit4Life Member Management");
				});

				this.errorText.setText("Login Successful");
				login.play();
			} else {
				this.errorText.setText("Incorrect Login Information");
			}
		});

		// Enter key event handler
		this.passWord.setOnAction(e -> {
			// Verify that the users login information is correct
			if (PasswordTable.verifyLogin(this.userName.getText(), this.passWord.getText())) {
				PauseTransition login = new PauseTransition(Duration.seconds(1));

				login.setOnFinished(event -> {
					Session.getInstance().setLoggedInUser(new User(this.userName.getText()));
					mainMenu = new MainMenu();
					Main.mainStage.setScene(mainMenu.getScene());
					Main.mainStage.setTitle("Fit4Life Member Management");
				});

				this.errorText.setText("Login Successful");
				login.play();

			} else {
				this.errorText.setText("Incorrect Login Information");
			}
		});
		;

		/*
		 * Adding the userName and passWord TextArea fields to the "Middle" VBox
		 */

		this.middle.getChildren().addAll(userName, passWord, errorText, login);
		this.middle.setSpacing(25);

		this.pane.setTop(top);
		this.pane.setCenter(middle);

		this.scene = new Scene(this.pane, 1024, 768);
		this.scene.getStylesheets().add("style/style.css");

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

	public VBox getMiddle() {
		return middle;
	}

	public void setMiddle(VBox middle) {
		this.middle = middle;
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

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public ImageView getLogoIV() {
		return logoIV;
	}

	public void setLogoIV(ImageView logoIV) {
		this.logoIV = logoIV;
	}
}
