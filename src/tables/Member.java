package tables;

import java.util.Date;

public class Member {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String postalCode;
	private City city;
	private Boolean activeMembership;
	private MemberLevel membershipLevel;
	private Location location;
	private Date registrationDate;
	
	// Constructors
	public Member(int id, String fname, String lname, String address, String postalCode, City city, Boolean activeMembership,
			MemberLevel membershipLevel, Location location, Date registrationDate) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.activeMembership = activeMembership;
		this.membershipLevel = membershipLevel;
		this.location = location;
		this.registrationDate = registrationDate;
	}

	public Member(String fname, String lname, String address, String postalCode, City city, Boolean activeMembership,
			MemberLevel membershipLevel, Location location, Date registrationDate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.activeMembership = activeMembership;
		this.membershipLevel = membershipLevel;
		this.location = location;
		this.registrationDate = registrationDate;
	}
	

	public Member() {
		
	}
	
	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFName() {
		return fname;
	}

	public void setFName(String fname) {
		this.fname = fname;
	}
	
	public String getLName() {
		return lname;
	}

	public void setLName(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Boolean getActiveMembership() {
		return activeMembership;
	}

	public void setActiveMembership(Boolean activeMembership) {
		this.activeMembership = activeMembership;
	}

	public MemberLevel getMembershipLevel() {
		return membershipLevel;
	}

	public void setMembershipLevel(MemberLevel membershipLevel) {
		this.membershipLevel = membershipLevel;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setActiveMembership(String selectedItem) {
		if(selectedItem.equals("true")) {
			this.activeMembership = true;
		} else {
			this.activeMembership = false;
		}
		
	}
	
	
	
	
	
	
}
