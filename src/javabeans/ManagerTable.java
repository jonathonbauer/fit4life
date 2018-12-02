package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.ManagerDAO;
import database.Database;
import database.Tables;
import tables.Manager;

/**
 * This class is used to hold all CRUD functionality for the Manager table in
 * the database
 *
 */
public class ManagerTable implements ManagerDAO {
	// Get the database connection
	Database db = Database.getInstance();
	ArrayList<Manager> managers;
	Manager manager;
	CityTable cityTable = new CityTable();

	/**
	 * This method is used to retrieve all Managers in the database
	 * 
	 * @return An arraylist of Manager objects
	 */
	public ArrayList<Manager> getAllManagers() {
		String query = "SELECT * FROM " + Tables.TABLE_MANAGERS;
		managers = new ArrayList<Manager>();

		try {
			Statement getManagers = db.getConnection().createStatement();
			ResultSet data;
			data = getManagers.executeQuery(query);
			while (data.next()) {
				managers.add(new Manager(data.getInt(Tables.MANAGERS_COLUMN_ID),
						data.getString(Tables.MANAGERS_COLUMN_FNAME), data.getString(Tables.MANAGERS_COLUMN_LNAME),
						data.getString(Tables.MANAGERS_COLUMN_ADDRESS),
						data.getString(Tables.MANAGERS_COLUMN_POSTALCODE),
						this.cityTable.getCity(data.getInt(Tables.LOCATIONS_COLUMN_CITY))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return managers;
	}

	/**
	 * This method is used to get a single Manager using its ID
	 * 
	 * @param managerID
	 *            is the ID of the manager we wish to retrieve
	 * 
	 * @return A single Manager object
	 */
	public Manager getManager(int managerID) {
		String query = "SELECT * FROM " + Tables.TABLE_MANAGERS + " WHERE " + Tables.MANAGERS_COLUMN_ID + " = "
				+ managerID;
		try {
			Statement getManager = db.getConnection().createStatement();
			ResultSet data = getManager.executeQuery(query);
			data.next();
			manager = new Manager(data.getInt(Tables.MANAGERS_COLUMN_ID), data.getString(Tables.MANAGERS_COLUMN_FNAME),
					data.getString(Tables.MANAGERS_COLUMN_LNAME), data.getString(Tables.MANAGERS_COLUMN_ADDRESS),
					data.getString(Tables.MANAGERS_COLUMN_POSTALCODE),
					this.cityTable.getCity(data.getInt(Tables.MANAGERS_COLUMN_CITY)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}

	/**
	 * This method is used to update an manager in the database
	 * 
	 * @param manager
	 *            an Manager object to be updated
	 * 
	 */
	public void updateManager(Manager manager) {
		String query = "UPDATE " + Tables.TABLE_MANAGERS + " SET " + Tables.MANAGERS_COLUMN_FNAME + " = '"
				+ manager.getFname() + "'," + Tables.MANAGERS_COLUMN_LNAME + " = '" + manager.getLname() + "',"
				+ Tables.MANAGERS_COLUMN_ADDRESS + " = '" + manager.getAddress() + "',"
				+ Tables.MANAGERS_COLUMN_POSTALCODE + " = '" + manager.getPostalCode() + "',"
				+ Tables.MANAGERS_COLUMN_CITY + " = '" + manager.getCity().getId() + "'" + " WHERE "
				+ Tables.MANAGERS_COLUMN_ID + " = " + manager.getId();
		try {
			Statement updateMember = db.getConnection().createStatement();
			updateMember.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to delete an manager out of the database
	 * 
	 * @param manager
	 *            an Manager object to be deleted
	 * 
	 */
	public void deleteManager(Manager manager) {
		String query = "DELETE FROM " + Tables.TABLE_MANAGERS + " WHERE " + Tables.MANAGERS_COLUMN_ID + " = "
				+ manager.getId();
		System.out.println("Manager has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to insert an manager in the database
	 * 
	 * @param manager
	 *            the Manager object to be created
	 * 
	 */
	public void createManager(Manager manager) {
		String query = "INSERT INTO " + Tables.TABLE_MANAGERS + "(" + Tables.MANAGERS_COLUMN_FNAME + ", "
				+ Tables.MANAGERS_COLUMN_LNAME + ", " + Tables.MANAGERS_COLUMN_ADDRESS + ", "
				+ Tables.MANAGERS_COLUMN_POSTALCODE + ", " + Tables.MANAGERS_COLUMN_CITY + ") VALUES ('"
				+ manager.getFname() + "','" + manager.getLname() + "','" + manager.getAddress() + "','"
				+ manager.getPostalCode() + manager.getCity().getId() + "');";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Manager has been created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
