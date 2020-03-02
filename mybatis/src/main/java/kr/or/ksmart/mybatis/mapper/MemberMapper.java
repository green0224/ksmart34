package kr.or.ksmart.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.or.ksmart.mybatis.domain.Member;

@Mapper
public interface MemberMapper {
	//db member table 모든 행을 가져오는 메서드 (쿼리문 xml에 구현)
	public List<Member> getMemberList();
	
	public List<Member> getSearchMemberList(String sk, String sv);
	
	public int mInsert(Member member);
	
	public Member SelectForUpdate(String mId);
	
	public int mUpdate(Member member);
	
	public int mDelete(String mId, String mPw);
}
 