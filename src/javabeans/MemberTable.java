package javabeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.MemberDAO;
import database.Database;
import database.Tables;
import tables.Member;

/**
 * This class is used to hold all CRUD functionality for the Member table in
 * the database
 *
 */
public class MemberTable implements MemberDAO {
	// Get the database connection
	Database db = Database.getInstance();
	ArrayList<Member> members;
	Member member;
	CityTable cityTable = new CityTable();
	MemberLevelTable memberLevelTable = new MemberLevelTable();
	LocationTable locationTable = new LocationTable();
	Member memberLocation;

	/**
	 * This method is used to retrieve all Members in the database
	 * 
	 * @return An arraylist of Member objects
	 */
	public ArrayList<Member> getAllMembers() {
		String query = "SELECT * FROM " + Tables.TABLE_MEMBERS;
		members = new ArrayList<Member>();

		try {

			Statement getMembers = db.getConnection().createStatement();
			ResultSet data;
			data = getMembers.executeQuery(query);
			while (data.next()) {
				members.add(new Member(data.getInt(Tables.MEMBERS_COLUMN_ID),
						data.getString(Tables.MEMBERS_COLUMN_FNAME), data.getString(Tables.MEMBERS_COLUMN_LNAME),
						data.getString(Tables.MEMBERS_COLUMN_ADDRESS), data.getString(Tables.MEMBERS_COLUMN_POSTALCODE),
						this.cityTable.getCity(data.getInt(Tables.MEMBERS_COLUMN_CITY)),
						data.getBoolean(Tables.MEMBERS_COLUMN_ACTIVE_MEMBERSHIP),
						this.memberLevelTable.getMemberLevel(data.getInt(Tables.MEMBERS_COLUMN_MEMBERSHIP_LEVEL)),
						this.locationTable.getLocation(data.getInt(Tables.MEMBERS_COLUMN_LOCATION)),
						data.getString(Tables.MEMBERS_COLUMN_REGISTRATION_DATE)
						));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	/**
	 * This method is used to get a single Member using its ID
	 * 
	 * @param memberID is the ID of the member we wish to retrieve
	 * 
	 * @return A single Member object
	 */
	public Member getMember(int memberID) {
		String query = "SELECT * FROM " + Tables.TABLE_MEMBERS + " WHERE " + Tables.MEMBERS_COLUMN_ID + " = "
				+ memberID;
		try {
			Statement getMember = db.getConnection().createStatement();
			ResultSet data = getMember.executeQuery(query);
			data.next();
			member = new Member(data.getInt(Tables.MEMBERS_COLUMN_ID), data.getString(Tables.MEMBERS_COLUMN_FNAME),
					data.getString(Tables.MEMBERS_COLUMN_LNAME), data.getString(Tables.MEMBERS_COLUMN_ADDRESS),
					data.getString(Tables.MEMBERS_COLUMN_POSTALCODE),
					this.cityTable.getCity(data.getInt(Tables.MEMBERS_COLUMN_CITY)),
					data.getBoolean(Tables.MEMBERS_COLUMN_ACTIVE_MEMBERSHIP),
					this.memberLevelTable.getMemberLevel(data.getInt(Tables.MEMBERS_COLUMN_MEMBERSHIP_LEVEL)),
					this.locationTable.getLocation(data.getInt(Tables.MEMBERS_COLUMN_LOCATION)),
					data.getString(Tables.MEMBERS_COLUMN_REGISTRATION_DATE));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	/**
	 * This method is used to update an member in the database
	 * 
	 * @param member an Member object to be updated
	 * 
	 */
	public void updateMember(Member member) {
		String query = "UPDATE " + Tables.TABLE_MEMBERS + " SET " + Tables.MEMBERS_COLUMN_FNAME + " = '"
				+ member.getFname() + "'," + Tables.MEMBERS_COLUMN_LNAME + " = '" + member.getLname() + "',"
				+ Tables.MEMBERS_COLUMN_ADDRESS + " = '" + member.getAddress() + "'," + Tables.MEMBERS_COLUMN_POSTALCODE
				+ " = '" + member.getPostalCode() + "'," + Tables.MEMBERS_COLUMN_CITY + " = '"
				+ member.getCity().getId() + "'," + Tables.MEMBERS_COLUMN_ACTIVE_MEMBERSHIP + " = "
				+ member.getActiveMembership() + "," + Tables.MEMBERS_COLUMN_MEMBERSHIP_LEVEL + " = '"
				+ member.getMembershipLevel().getId() + "'," + Tables.MEMBERS_COLUMN_LOCATION + " = '"
				+ member.getLocation().getId() + "'," + Tables.MEMBERS_COLUMN_REGISTRATION_DATE + " = '"
				+ member.getRegistrationDate() + "'" + " WHERE " + Tables.MEMBERS_COLUMN_ID + " = " + member.getId();
		try {
			Statement updateMember = db.getConnection().createStatement();
			updateMember.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to delete an member out of the database
	 * 
	 * @param member an Member object to be deleted
	 * 
	 */
	public void deleteMember(Member member) {
		String query = "DELETE FROM " + Tables.TABLE_MEMBERS + " WHERE " + Tables.MEMBERS_COLUMN_ID + " = "
				+ member.getId();
		System.out.println("Member has been deleted.");
		try {
			db.getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to insert an member in the database
	 * 
	 * @param member the Member object to be created
	 * 
	 */
	public void createMember(Member member) {

		String query = "INSERT INTO " + Tables.TABLE_MEMBERS + "("
				+ Tables.MEMBERS_COLUMN_FNAME + ", "
				+ Tables.MEMBERS_COLUMN_LNAME + ", "
				+ Tables.MEMBERS_COLUMN_ADDRESS + ", "
				+ Tables.MEMBERS_COLUMN_POSTALCODE + ", "
				+ Tables.MEMBERS_COLUMN_CITY + ", "
				+ Tables.MEMBERS_COLUMN_ACTIVE_MEMBERSHIP + ", "
				+ Tables.MEMBERS_COLUMN_MEMBERSHIP_LEVEL + ", "
				+ Tables.MEMBERS_COLUMN_LOCATION + ", "
				+ Tables.MEMBERS_COLUMN_REGISTRATION_DATE + ") VALUES ('" 
				+ member.getFname() + "','" + member.getLname() + "','" + member.getAddress() + "','" + member.getPostalCode() + "','"
				+ member.getCity().getId() + "','" + "1" + "','" + member.getMembershipLevel().getId()
				+ "','" + member.getLocation().getId() + "','" + member.getRegistrationDate() +"');";

		try {
			db.getConnection().createStatement().execute(query);
			System.out.println("Member has been created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * This method is used to retrieve all members that are at the location specified
	 * 
	 * @param locationID is the ID of the location we are retrieving members from
	 * @return an ArrayList of member objects that are at the location specified
	 */
	public ArrayList<Member> getMemberLocation(int locationID) {
		ArrayList<Member> members = new ArrayList<>();
		String query = "SELECT * FROM " + Tables.TABLE_MEMBERS + " WHERE " + Tables.MEMBERS_COLUMN_LOCATION + " = "
				+ locationID;
		try {
			Statement getMemberLocation = db.getConnection().createStatement();
			ResultSet data = getMemberLocation.executeQuery(query);
			//data.next();
			while(data.next()) {
			 members.add(new Member(data.getInt(Tables.MEMBERS_COLUMN_ID),
					data.getString(Tables.MEMBERS_COLUMN_FNAME),
					data.getString(Tables.MEMBERS_COLUMN_LNAME),
					data.getString(Tables.MEMBERS_COLUMN_ADDRESS),
					data.getString(Tables.MEMBERS_COLUMN_POSTALCODE),
					this.cityTable.getCity(data.getInt(Tables.MEMBERS_COLUMN_CITY)),
					data.getBoolean(Tables.MEMBERS_COLUMN_ACTIVE_MEMBERSHIP),
					this.memberLevelTable.getMemberLevel(data.getInt(Tables.MEMBERS_COLUMN_MEMBERSHIP_LEVEL)),
					this.locationTable.getLocation(data.getInt(Tables.MEMBERS_COLUMN_LOCATION)),
					data.getString(Tables.MEMBERS_COLUMN_REGISTRATION_DATE)));
			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}
}
