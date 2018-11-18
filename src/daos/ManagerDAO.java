package daos;
import java.util.ArrayList;

import tables.Manager;

public interface ManagerDAO {
	public ArrayList<Manager> getAllManagers();
	public Manager getManager(int managerID);
	public void updateManager(Manager manager);
	public void deleteManager(Manager manager);
	public void createManager(Manager manager);

}
