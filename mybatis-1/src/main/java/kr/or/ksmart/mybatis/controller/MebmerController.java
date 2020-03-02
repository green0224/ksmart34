package kr.or.ksmart.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.mybatis.service.MebmerService;

@Controller
public class MebmerController {
	
	@Autowired
	private MebmerService meberserivce;
	
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		model.addAttribute("memberList", meberserivce.getMemberList());
		return "mlist/memberList";
	}
}
