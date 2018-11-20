package tables;

import java.util.Date;

public class Member {
	private int id;
	private String name;
	private String address;
	private String postalCode;
//	TODO: Change to appropriate classes
	private City city;
	private Boolean activeMembership;
	private MemberLevel membershipLevel;
	private Date registrationDate;
	
	// Constructors
	public Member(int id, String name, String address, String postalCode, City city, Boolean activeMembership,
			MemberLevel membershipLevel, Date registrationDate) {
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

	public Member(String name, String address, String postalCode, City city, Boolean activeMembership,
			MemberLevel membershipLevel, Date registrationDate) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.activeMembership = activeMembership;
		this.membershipLevel = membershipLevel;
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
