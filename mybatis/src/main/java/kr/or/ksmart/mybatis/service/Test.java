package kr.or.ksmart.mybatis.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.mybatis.mapper.BoardMapping;

@Service
@Transactional
public class Test {
	@Autowired
	private BoardMapping boardmpper;
	
	public Map<String, Object> boardAllList(int currenPage){
		//몇개의 행을 보여 줄지
		final int ROW_PER_PAGE =10;
		
		int startPageNum = 1;
		
		//보여줄 페이지 갯수
		int endPageNum = ROW_PER_PAGE;
		
		//6개 부터 바뀌게 보이게 할 경우 
		if(currenPage > (ROW_PER_PAGE/2)) {
			startPageNum = currenPage -((endPageNum/2)-1);
			endPageNum += startPageNum;
		}
		
		int startRow =()
		return null;
	}
	
}
