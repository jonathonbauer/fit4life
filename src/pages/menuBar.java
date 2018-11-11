package pages;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class menuBar extends MenuBar {

	private Menu menuFile;
	private Menu menuEdit;
	private Menu menuView;
	
	public menuBar() {
		
		this.menuFile = new Menu("File");
		this.menuEdit = new Menu("Edit");
		this.menuView = new Menu("View");
		
		
		this.menuFile.setOnAction(e->{
			System.out.println("File Menu Clicked");
		});
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
