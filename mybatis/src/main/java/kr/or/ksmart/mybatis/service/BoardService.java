package kr.or.ksmart.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.mybatis.domain.Board;
import kr.or.ksmart.mybatis.mapper.BoardMapping;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardMapping boardmpper;
	
	public Map<String, Object> boardAllList(int currenPage){
		//몇개의 행을 보여 줄지
		final int ROW_PER_PAGE =10;
		
		//보여줄 첫번쨰 페이지 번호 초기화
		int startPageNum = 1;
		
		//보여줄 페이지 갯수
		int endPageNum = ROW_PER_PAGE;
		
		//페이지 6번째 부터 startPageNum 변동
		if(currenPage > (ROW_PER_PAGE/2)) {
			startPageNum = currenPage - ((endPageNum/2)-1);
			endPageNum += (startPageNum-1);
		}
		
		//페이지 알고리즘
		int startRow = (currenPage-1)*ROW_PER_PAGE;
		
		//limit 적용할 startRow, ROW_PER_PAGE(몇개행)
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		//전체 카운트
		double count = boardmpper.getBoardRowCount();
	
		//마지막 페이지 
		int lastPage = (int) Math.ceil(count/ROW_PER_PAGE);
		
		if(currenPage >=  (lastPage-4)) {
			endPageNum = lastPage;
		}
		
		//limit로 설정된 목록 가져옴
		List<Board> list = boardmpper.bAllList(map);
		
		//controller에 페이지 관련 객체 전달
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("BoardList", list);
		resultMap.put("currenPage", currenPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		
		return resultMap;
	}
}
