package daos;

import java.util.ArrayList;

import tables.Manager;

/**
 * 
 * This data access object is used to tell the ManagerTable object what
 * functionality it needs to provide.
 * 
 *
 */
public interface ManagerDAO {
	public ArrayList<Manager> getAllManagers();

	public Manager getManager(int managerID);

	public void updateManager(Manager manager);

	public void deleteManager(Manager manager);

	public void createManager(Manager manager);

}
