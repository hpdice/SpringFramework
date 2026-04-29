package com.example.hello.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@GetMapping("/signUp")
	public String signUp(@RequestParam String name,Model model) {
		model.addAttribute("name",name);
		return "sign_up";
	}
	
	@GetMapping("/signIn")
	public String signIn(@RequestParam String name,Model model) {
		model.addAttribute("name",name);
		return "sign_in";
	}

}
