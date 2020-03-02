package kr.or.ksmart.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.mybatis.domain.Board;

@Mapper
public interface BoardMapping {
	public List<Board> bAllList(Map<String, Object> map);
	
	public int getBoardRowCount();
}
