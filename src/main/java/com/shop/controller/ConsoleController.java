package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.model.Product;
import com.shop.service.ProductService;

@Controller
public class ConsoleController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/showConsole")
	public String showConsole(final Model model) {
		List<Product> allProduct = productService.getAll();
		model.addAttribute("allProduct", allProduct);
		return "/staff/console";
	}
}
