package com.sosam.hiking.controller;

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

	@GetMapping("/ch/rain")
	public String rain() {
		return "content/rain";
	}

	@GetMapping("/ch/fire")
	public String fire() {
		return "content/fire";
	}
}
