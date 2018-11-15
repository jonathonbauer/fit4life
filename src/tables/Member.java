package tables;

import java.util.Date;

public class Member {
	private int id;
	private String name;
	private String address;
	private String postalCode;
//	TODO: Change to appropriate classes
	private String city;
	private Boolean activeMembership;
	private String membershipLevel;
	private Date registrationDate;
	
	// Constructors
	public Member(int id, String name, String address, String postalCode, String city, Boolean activeMembership,
			String membershipLevel, Date registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.activeMembership = activeMembership;
		this.membershipLevel = membershipLevel;
		this.registrationDate = registrationDate;
	}

	public Member(String name, String address, String postalCode, String city, Boolean activeMembership,
			String membershipLevel, Date registrationDate) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.activeMembership = activeMembership;
		this.membershipLevel = membershipLevel;
		this.registrationDate = registrationDate;
	}
	
	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getActiveMembership() {
		return activeMembership;
	}

	public void setActiveMembership(Boolean activeMembership) {
		this.activeMembership = activeMembership;
	}

	public String getMembershipLevel() {
		return membershipLevel;
	}

	public void setMembershipLevel(String membershipLevel) {
		this.membershipLevel = membershipLevel;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	
	
	
	
}
