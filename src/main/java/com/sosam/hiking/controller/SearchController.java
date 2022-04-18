package com.sosam.hiking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch/lists")
public class SearchController {
	
	@GetMapping("")
	public String mntn(Model model, String keyword) {
		model.addAttribute("keyword", keyword);
		return "content/mntnLst";
	}
}
