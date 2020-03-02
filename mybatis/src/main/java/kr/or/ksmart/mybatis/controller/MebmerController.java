package kr.or.ksmart.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.mybatis.domain.Member;
import kr.or.ksmart.mybatis.service.MebmerService;

@Controller
public class MebmerController {
	
	@Autowired
	private MebmerService memberService;
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login1(@RequestParam(value="mId", required=false) String mId, @RequestParam(value="mPw", required = false) String mPw,
			RedirectAttributes redirectA, HttpSession session) {
		System.out.println("binding test mId:" + mId + " : " +mPw);
		Member m = memberService.selectForUpdate(mId);
		
		if(m != null && mPw != null && !"".equals(mPw)&&mPw.equals(m.getmPw())) {
			session.setAttribute("SID", m.getmId());
			session.setAttribute("SNAME", m.getmName());
			session.setAttribute("SLEVEL", m.getmLevel());
			return "redirect:/memberList";
		}else{
			redirectA.addAttribute("result", "등록된 회원이 아닙니다 ");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value="result", required = false) String result, Model model) {
		model.addAttribute("result", result);
		return "login/login";
	}
	
	@PostMapping("/memberList")
	public String memberList(@RequestParam(value="sk") String sk, @RequestParam(value="sv", required=false) String sv, Model model) {
		System.out.println("binding test sk:" +sk);
		System.out.println("binding test sv:" +sv);
		
		List<Member>  list = memberService.getSearchMemberList(sk, sv);
		model.addAttribute("memberList", list);
		return "mlist/memberList";
		
	}
	
	@PostMapping("/mDelete")
		public String mDelete(@RequestParam(value="mId") String mId, @RequestParam(value="mPw", required= false) String mpw,
				RedirectAttributes redirectA) {
				Member m = memberService.selectForUpdate(mId);
				if(mpw != null && !"".equals(mpw)&&mpw.equals(m.getmPw())) {
					memberService.mDelete(mId, mpw);
					return "redirect:/memberList";
				}else{
					redirectA.addAttribute("mId", mId);
					return "redirect:/mDelete";
				}
		}
	
	
	/*
	@PostMapping("/mDelete1")
	public String mDelete1(@RequestParam(value="mId") String mId, @RequestParam(value="mPw") String mpw, Model model) {
		String text = memberService.mDelete(mId, mpw);
		model.addAttribute("text", text);
		return "redirect:/memberList";
	}
	
	*/
	@GetMapping("/mDelete")
	
	public String mDelete(@RequestParam(value="mId") String mId, Model model) {
		model.addAttribute("mId", mId);
	
		return "mdelete/mdelete";
	}
	
	@PostMapping("/mUpdate")
	public String mUpdate(Member member) {
		System.out.println(member.toString());
		int result = memberService.Update(member);
		if(result >0) {
			return "redirect:/memberList";
		}
		return "redirect:/mUpdate";
	}
	
	@GetMapping("/mUpdate")
	public String mUpdate(@RequestParam(value = "mId") String mId, Model model) {
		System.out.println("binding Test: "+mId);
		System.out.println("binding Test2: "+memberService.selectForUpdate(mId).toString());
		model.addAttribute("Member", memberService.selectForUpdate(mId));
		return "mUpdate/mUpdate";
	}
	
	
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		model.addAttribute("memberList", memberService.getMemberList());
		System.out.println(memberService.getMemberList().toString());
		return "mlist/memberList";
	}
	
	@GetMapping("/mInsert")
	public String mInsert() {
		return "minsert/minsert";
	}

	@PostMapping("/mInsert")
	public String mInsert1(Member member){
		System.out.println(member.toString());
		int result = memberService.mInsert(member);
		if(result >0) {
			return "redirect:/memberList";
		}
	/*
	도메인 객체(VO)에 담지 않고 값을 받았을 경우 
	public String mInsert1(@RequestParam(value="mId", required = false) String mId) {
		System.out.println("binding test: "+mId);
	 * 도메일 객체에 담았을 경우 
	public String mInsert1(Member member){
		System.out.println(member.toString());
		int result = memberService.mInsert(member);
		if(result >0) {
			return "redirect:/memberList";
		}
		*/
		return "redirect:/mInsert";
	}
}
