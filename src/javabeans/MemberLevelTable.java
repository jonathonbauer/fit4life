package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.MemberLevelDAO;
import database.Database;
import database.Tables;
import tables.MemberLevel;

/**
 * This class is used to hold all CRUD functionality for the MemberLevel table
 * in the database
 *
 */
public class MemberLevelTable implements MemberLevelDAO {

	// database connection
	Database db = Database.getInstance();
	ArrayList<MemberLevel> memberLevels;
	MemberLevel memberLevel;

	/**
	 * This method is used to retrieve all MemberLevels in the database
	 * 
	 * @return An arraylist of MemberLevel objects
	 */
	public ArrayList<MemberLevel> getAllMemberLevels() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM " + Tables.TABLE_MEMBER_LEVEL;
		memberLevels = new ArrayList<MemberLevel>();

		try {
			Statement getMemberLevels = db.getConnection().createStatement();
			ResultSet data;
			data = getMemberLevels.executeQuery(query);
			while (data.next()) {
				memberLevels.add(new MemberLevel(data.getInt(Tables.MEMBER_LEVELS_COLUMN_ID),
						data.getString(Tables.MEMBER_LEVELS_COLUMN_NAME)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return memberLevels;
	}

	/**
	 * This method is used to retrieve all the string name values in the Member Level table
	 * 
	 * @return an ArrayList of Member Levels in string form
	 */
	public ArrayList<String> getAllLevelNames() {
		String query = "SELECT " + Tables.MEMBER_LEVELS_COLUMN_NAME + " FROM " + Tables.TABLE_MEMBER_LEVEL;
		ArrayList<String> levels = new ArrayList<String>();

		try {
			Statement getLevels = db.getConnection().createStatement();
			ResultSet data;
			data = getLevels.executeQuery(query);
			while (data.next()) {
				levels.add(data.getString(Tables.MEMBER_LEVELS_COLUMN_NAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return levels;

	}

	/**
	 * This method is used to get a single MemberLevel using its ID
	 * 
	 * @param memberLevelID
	 *            is the ID of the member level we wish to retrieve
	 * 
	 * @return A single MemberLevel object
	 */
	public MemberLevel getMemberLevel(int memberLevelID) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM " + Tables.TABLE_MEMBER_LEVEL + " WHERE " + Tables.MEMBER_LEVELS_COLUMN_ID + " = "
				+ memberLevelID;

		try {
			Statement getMemberLevel = db.getConnection().createStatement();
			ResultSet data;
			data = getMemberLevel.executeQuery(query);
			while (data.next()) {
				memberLevel = new MemberLevel(data.getInt(Tables.MEMBER_LEVELS_COLUMN_ID),
						data.getString(Tables.MEMBER_LEVELS_COLUMN_NAME));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return memberLevel;
	}
	/**
	 * This method is used to update an memberLevel in the database
	 * 
	 * @param memberLevel an MemberLevel object to be updated
	 * 
	 */
	public void updateMemberLevel(MemberLevel memberLevel) {
		// TODO Auto-generated method stub
		String query = "UPDATE " + Tables.TABLE_MEMBER_LEVEL + " SET " + Tables.MEMBER_LEVELS_COLUMN_NAME + " "
				+ memberLevel.getLevel();
		try {
			Statement updateMember = db.getConnection().createStatement();
			@SuppressWarnings("unused")
			ResultSet data;
			data = updateMember.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to delete an memberLevel out of the database
	 * 
	 * @param memberLevel an MemberLevel object to be deleted
	 * 
	 */
	public void deleteMemberLevel(MemberLevel memberLevel) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM " + Tables.TABLE_MEMBER_LEVEL + " WHERE " + Tables.MEMBER_LEVELS_COLUMN_NAME + " = "
				+ memberLevel.getId();
		System.out.println("Member Level has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to insert an memberLevel in the database
	 * 
	 * @param memberLevel the MemberLevel object to be created
	 * 
	 */
	public void createMemberLevel(MemberLevel memberLevel) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO " + Tables.TABLE_MEMBER_LEVEL + "(" + Tables.MEMBER_LEVELS_COLUMN_NAME
				+ ") VALUES ('" + memberLevel.getLevel() + "');";
		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("MemberLevel successfully created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
