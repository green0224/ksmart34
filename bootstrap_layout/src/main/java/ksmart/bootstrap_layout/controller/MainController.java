package ksmart.bootstrap_layout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/1")
	public String index1() {
		return "index1";
	}
	@GetMapping("/2")
	public String index2() {
		return "index2";
	}
	
	@GetMapping("/calendar")
	public String calendar() {
		return "calendar";
	}
	
	@GetMapping("/maintest")
	public String maintest() {
		return "maintest";
	}
	
}
