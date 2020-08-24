package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(final Model model) {
		model.addAttribute("message", "hello beo den");
		return "/index";
	}
	
	@GetMapping("/home")
	public String showHome(final Model model) {
		
		return "home";
	}
}
