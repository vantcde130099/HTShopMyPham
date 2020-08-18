package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.model.Customer;
import com.shop.service.CustomerDetailService;


@Controller
public class RegisterController {
	@Autowired
	private CustomerDetailService customerService ;

	@RequestMapping(value = "showRegister")
	public String showRegister(Model model) {
		model.addAttribute("Customer", new Customer());
		return "register";
	}

	@RequestMapping(value = "customerRegister")
	public String Register(@ModelAttribute("Customer") Customer customer, Model model) {
		if (customerService.register(customer)) {
			model.addAttribute("Customer", new Customer());
			model.addAttribute("success", "Registered, let login now!");
			return "redirect:showLogin";
		}else {
			model.addAttribute("error", true);
			return "redirect:showRegister";
		}
	}
}
