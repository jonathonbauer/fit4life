package daos;

import java.util.ArrayList;

import tables.MemberLevel;

/**
 * 
 * This data access object is used to tell the MemberLevelTable object what
 * functionality it needs to provide.
 * 
 *
 */
public interface MemberLevelDAO {
	public ArrayList<MemberLevel> getAllMemberLevels();

	public MemberLevel getMemberLevel(int MemberLevelID);

	public void updateMemberLevel(MemberLevel MemberLevel);

	public void deleteMemberLevel(MemberLevel MemberLevel);

	public void createMemberLevel(MemberLevel MemberLevel);
}
