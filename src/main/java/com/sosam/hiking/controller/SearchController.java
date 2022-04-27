package com.sosam.hiking.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.service.SearchService;

@Controller
@RequestMapping("/ch/lists")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@GetMapping("/normal")
	public String normal(Model model, String keyword) {
		model.addAttribute("keyword", keyword);
		return "content/mntnLst";
	}
	
	@GetMapping("/simple")
	public String simple(HttpSession session, Model model) {
		model.addAttribute("flag", true);
		return "content/mntnLst";
	}
}
