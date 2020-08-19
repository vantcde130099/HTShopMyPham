package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.model.Customer;
import com.shop.service.UserDetailService;

@Controller
public class LoginController {
	@Autowired
	private UserDetailService customerService;

	@RequestMapping(value = "/showLogin")
	public String showLogin(Model model) {
		model.addAttribute("Customer", new Customer());
		return "login";
	}

//	@RequestMapping(value = "/login") // action
//	public String login(@ModelAttribute("Customer") Customer customer, Model model) {
//		if (customerService.login(customer)) {
//			model.addAttribute("Customer", customer);
//			return "redirect:/products";
//		}else {
//			model.addAttribute("error", true);
//			return "redirect:/showLogin";
//		}
//	}
}
