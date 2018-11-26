package tables;

public class MemberLevel {
	private int id;
	private String level;
	
	public MemberLevel(int id, String level) {
		super();
		this.id = id;
		this.level = level;
	}
	public MemberLevel(String level) {
		super();
		this.level = level;
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
	
	public String toString() {
		return this.level;
	}
}
