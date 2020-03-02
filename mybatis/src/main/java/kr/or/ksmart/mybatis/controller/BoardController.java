package kr.or.ksmart.mybatis.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.mybatis.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardservice;
	
	@GetMapping("/boardList")
	public String boardList(@RequestParam(value="currentPage", required = false , defaultValue = "1") int currentPage, Model model) {
		logger.info("currentPage :: {}", currentPage);
		Map<String, Object> map = boardservice.boardAllList(currentPage);
		
		model.addAttribute("BoardList", map.get("BoardList"));
		model.addAttribute("currenPage", map.get("currenPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("endPageNum", map.get("endPageNum"));
		return "mlist/boardList";
	}
}
