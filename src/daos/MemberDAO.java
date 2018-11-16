package daos;

import java.util.ArrayList;

import tables.Member;

public interface MemberDAO {
	public ArrayList<Member> getAllMembers();
	public Member getMember(int memberID);
	public void updateMember(Member member);
	public void deleteMember(Member member);
	public void createMember(Member member);
	
}
