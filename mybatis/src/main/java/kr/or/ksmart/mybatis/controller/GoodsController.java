package kr.or.ksmart.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.mybatis.domain.Goods;
import kr.or.ksmart.mybatis.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsservice;
	
	//등록
	@PostMapping("/gInsert")
	public String gInsert(Goods g) {
		int result = goodsservice.gInsert(g);
		System.out.println(g.toString());
		if(result > 0) {
			return "redirect:/gList";
		}
		return "redirect:/gInsert";
	}
	
	@GetMapping("/gInsert")
	public String gInsert1() {
		return "minsert/gInsert";
	}
	
	//전체리스트
	@GetMapping("/gList")
	public String goodsList(Model model) {
		List<Goods> g = goodsservice.gList();
		model.addAttribute("goodsList", g);
		return "mlist/goodsList";
	}
	
	@PostMapping("/gList")
	public String goodsList1(@RequestParam(value="sk") String sk, @RequestParam(value="sv", required=false) String sv, Model model) {
		List<Goods> g = goodsservice.selectList(sk, sv);
		model.addAttribute("goodsList", g);
		return "mlist/goodsList";
	}
	
	//업데이트
	@GetMapping("/gUdpate")
	public String goodsUpdate(@RequestParam(value="gCode" , required=false) String gCode, Model model) {
		Goods g = goodsservice.oneSelect(gCode);
		model.addAttribute("Goods", g);
		return "mUpdate/goodsUpdate";	
	}
	
	@PostMapping("/gUdpate")
	public String goodsUpdate1(Goods g) {
		int result= goodsservice.goodsUpdate(g);
		if(result > 0) {
			return "redirect:/gList";
		}
		return "redirect:/gUdpate";
	}
	
	//삭제
	@GetMapping("/gDelete")
	public String gDelete(@RequestParam(value="gCode") String gCode, @RequestParam(value="mId") String mId , Model model) {
		model.addAttribute("gCode", gCode);
		model.addAttribute("mId", mId);
		return "mdelete/goodsDelete";
	}
	
	@PostMapping("/goodsDelete")
	public String gDelete(@RequestParam(value="gCode") String gCode, @RequestParam(value="mId") String mId, 
			@RequestParam(value="mPw", required=false) String mPw,
			RedirectAttributes redirectA) {
		String pw = goodsservice.goodsPw(gCode, mId);
		
		if(mPw != null && !"".equals(mPw)&&mPw.equals(pw)) {
			goodsservice.gDelete(gCode);
			return "redirect:/gList";
		}else {
			redirectA.addAttribute("mId", mId);
			redirectA.addAttribute("gCode", gCode);
			return "redirect:/gDelete";
		}
	}
}
