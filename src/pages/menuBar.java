package pages;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class menuBar extends MenuBar {

	private Menu menuFile;
	private Menu menuEdit;
	private Menu menuView;
	
	private MenuItem exit;
	private MenuItem logOut;
	private MenuItem back;
	private MenuItem settings;
	private MenuItem credits;
	
	
	public menuBar() {
		
		//Adding Values to Menus
		this.menuFile = new Menu("File");
		this.menuEdit = new Menu("Edit");
		this.menuView = new Menu("View");
		
		
		//Adding Values to MenuItems
		this.exit = new MenuItem("Exit");
		this.logOut = new MenuItem("Log Out");
		this.back = new MenuItem("Back");
		this.settings = new MenuItem("Settings");
		this.credits = new MenuItem("Credits");
		
		
		//Adding MenuItems to Menu "File"
		this.menuFile.getItems().addAll(exit, logOut, back, settings, credits);
		
		/* EVENT HANDLERS
		 *  this represents blocks of code that is only run  once the desired MenuItem is clicked
		 */
		
		//EXIT - Exits the program
		this.exit.setOnAction(e->{
			System.out.println("Exit MenuItem Clicked");
		});
		
		//LOGOUT - Brings the user to the login page with no information saved
		this.logOut.setOnAction(e->{
			System.out.println("Logout MenuItem Clicked");
		});
		//BACK - Returns the user to the previous page
		this.back.setOnAction(e->{
			System.out.println("Back MenuItem Clicked");
		});
		//SETTINGS - brings user to Settings Menu
		this.settings.setOnAction(e->{
			System.out.println("Settings MenuItem Clicked");
		});
		//CREDITS - brings user to Credits Menu
		this.credits.setOnAction(e->{
			System.out.println("Credits MenuItem Clicked");
		});
		
		this.getMenus().addAll(this.menuFile,this.menuEdit,this.menuView);
	}

	public Menu getMenuFile() {
		return menuFile;
	}

	public void setMenuFile(Menu menuFile) {
		this.menuFile = menuFile;
	}

	public Menu getMenuEdit() {
		return menuEdit;
	}

	public void setMenuEdit(Menu menuEdit) {
		this.menuEdit = menuEdit;
	}

	public Menu getMenuView() {
		return menuView;
	}

	public void setMenuView(Menu menuView) {
		this.menuView = menuView;
	}
}
