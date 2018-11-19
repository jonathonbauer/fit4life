package pages;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import main.Main;

public class menuBar extends MenuBar {

	public MainMenu mainMenu;
	public LogInMenu logInMenu;
	public Credits creditsPage;
	
	private Menu menuFile;
	private Menu menuGoto;
	
	private MenuItem exit;
	private MenuItem logOut;
	private MenuItem back;
	private MenuItem settings;
	private MenuItem credits;
	
	
	public menuBar() {
		
		//Adding Values to Menus
		this.menuFile = new Menu("File");
		this.menuGoto = new Menu("Go To");
		
		
		//Adding Values to MenuItems
		this.exit = new MenuItem("Exit");
		this.logOut = new MenuItem("Log Out");
		this.back = new MenuItem("Back");
		this.settings = new MenuItem("Settings");
		this.credits = new MenuItem("Credits");
		
		
		//Adding MenuItems to Menus
		this.menuFile.getItems().addAll(exit, back);
		
		this.menuGoto.getItems().addAll(logOut, credits, settings);
		
		/* EVENT HANDLERS
		 *  this represents blocks of code that is only run  once the desired MenuItem is clicked
		 */
		
		//EXIT - Exits the program
		this.exit.setOnAction(e->{
			System.out.println("Exit MenuItem Clicked");
			System.out.print("Exiting the program...");
			
			System.exit(0);
			
		});
		
		//LOGOUT - Brings the user to the login page with no information saved
		this.logOut.setOnAction(e->{
			System.out.println("Logout MenuItem Clicked");
			System.out.println("Returning to Login Page...");
			
			logInMenu = new LogInMenu();
			Main.mainStage.setScene(logInMenu.getScene());
			Main.mainStage.setTitle("Fit4Life Member Management");
		});
		//BACK - Returns the user to the previous page
		this.back.setOnAction(e->{
			System.out.println("Back MenuItem Clicked");
		});
		//SETTINGS - Brings user to Settings Menu
		this.settings.setOnAction(e->{
			System.out.println("Settings MenuItem Clicked");
			System.out.println("Heading to Settings Page...");
			
			//settingsPage = new Settings();
			//Main.mainStage.setScene(settingsPage.getScene());
			//Main.mainStage.setTitle("Fit4Life Member Management");
		});
		//CREDITS - Brings user to Credits Menu
		this.credits.setOnAction(e->{
			System.out.println("Credits MenuItem Clicked");
			System.out.println("Heading to Credits Page...");
			
			creditsPage = new Credits();
			Main.mainStage.setScene(creditsPage.getScene());
			Main.mainStage.setTitle("Fit4Life Member Management");
		});
		
		this.getMenus().addAll(this.menuFile,this.menuGoto);
	}
	
	public Credits getCreditsPage() {
		return creditsPage;
	}

	public void setCreditsPage(Credits creditsPage) {
		this.creditsPage = creditsPage;
	}

	public LogInMenu getLogInMenu() {
		return logInMenu;
	}

	public void setLogInMenu(LogInMenu logInMenu) {
		this.logInMenu = logInMenu;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public Menu getMenuFile() {
		return menuFile;
	}

	public void setMenuFile(Menu menuFile) {
		this.menuFile = menuFile;
	}

	public Menu getMenuGoto() {
		return menuGoto;
	}

	public void setMenuGoto(Menu menuGoto) {
		this.menuGoto = menuGoto;
	}

}