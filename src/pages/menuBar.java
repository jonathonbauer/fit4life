package pages;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import main.Main;
import main.Session;

public class menuBar extends MenuBar {

	public MainMenu mainMenu;
	public LogInMenu logInMenu;
	public Credits creditsPage;
	
	private Menu menuFile;	
	private MenuItem exit;
	private MenuItem logOut;

	private MenuItem credits;
	
	
	public menuBar() {
		
		//Adding Values to Menus
		this.menuFile = new Menu("File");

		//Adding Values to MenuItems
		this.exit = new MenuItem("Exit");
		this.logOut = new MenuItem("Log Out");
		this.credits = new MenuItem("Credits");
		
		
		//Adding MenuItems to Menus
		this.menuFile.getItems().addAll(credits, logOut, exit);
		
		
		/* EVENT HANDLERS
		 *  this represents blocks of code that is only run  once the desired MenuItem is clicked
		 */
		
		//EXIT - Exits the program
		this.exit.setOnAction(e->{
			System.exit(0);
		});
		
		//LOGOUT - Brings the user to the login page with no information saved
		this.logOut.setOnAction(e->{
			
			Session.getInstance().logOut();
			logInMenu = new LogInMenu();
			Main.mainStage.setScene(logInMenu.getScene());
			Main.mainStage.setTitle("Fit4Life Member Management");
		});
		
		//CREDITS - Brings user to Credits Menu
		this.credits.setOnAction(e->{
			creditsPage = new Credits();
			Main.mainStage.setScene(creditsPage.getScene());
			Main.mainStage.setTitle("Fit4Life Member Management");
		});
		
		this.getMenus().add(this.menuFile);
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


}