package daos;

import java.util.ArrayList;

import tables.MemberLevel;


public interface MemberLevelDAO {
	public ArrayList<MemberLevel> getAllMemberLevels();
	public MemberLevel getMemberLevel(int MemberLevelID);
	public void updateMemberLevel(MemberLevel MemberLevel);
	public void deleteMemberLevel(MemberLevel MemberLevel);
	public void createMemberLevel(MemberLevel MemberLevel);
}
