package kr.or.ksmart.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.mybatis.domain.Member;
import kr.or.ksmart.mybatis.mapper.MemberMapper;

@Service
@Transactional
public class MebmerService {

	@Autowired
	private MemberMapper memberMapper;
	
	public List<Member> getMemberList(){
		//List<Member> mlist = memberMapper.getMemberList();
		return memberMapper.getMemberList();
	}
	
	public List<Member> getSearchMemberList(String sk, String sv){
		//List<Member> mlist = memberMapper.getMemberList();
		return memberMapper.getSearchMemberList(sk, sv);
	}
	
	
	public int mInsert(Member member) {
		
		return memberMapper.mInsert(member);
	}
	
	public Member selectForUpdate(String mId) {
		return memberMapper.SelectForUpdate(mId);
	}
	
	public int Update(Member member) {
		return memberMapper.mUpdate(member);
	}
	
	public int mDelete(String mId, String mPw) {
		return memberMapper.mDelete(mId, mPw);
	}
}
