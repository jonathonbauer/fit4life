package daos;

import java.util.ArrayList;

import tables.Member;

/**
 * 
 * This data access object is used to tell the MemberTable object what
 * functionality it needs to provide.
 * 
 *
 */
public interface MemberDAO {
	public ArrayList<Member> getAllMembers();

	public Member getMember(int memberID);

	public void updateMember(Member member);

	public void deleteMember(Member member);

	public void createMember(Member member);

}
