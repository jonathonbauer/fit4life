package tables;

public class MemberLevel {
	private int id;
	private String level;
	
	public MemberLevel(int id, String amenity) {
		super();
		this.id = id;
		this.level = amenity;
	}
	public MemberLevel(String amenity) {
		super();
		this.level = amenity;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
}
