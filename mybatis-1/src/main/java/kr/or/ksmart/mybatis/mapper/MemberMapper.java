package kr.or.ksmart.mybatis.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.mybatis.domain.Member;

@Mapper
public interface MemberMapper {
	public List<Member> getMemberList();
	
}
