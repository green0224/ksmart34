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
	private MemberMapper mebermapper;
	
	public List<Member> getMemberList(){
		return mebermapper.getMemberList();
	}
}
