package com.sosam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/ch";
	}
	
	@GetMapping("/ch")
	public String home() {
		return "content/main";
	}
}
