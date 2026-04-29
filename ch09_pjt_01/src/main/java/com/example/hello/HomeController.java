package com.example.hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
 @GetMapping("/")
 public String home(Model model) {
	 model.addAttribute("message","안녕하세요!");
	 return "home";
}
}