package com.sosam.hiking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sg")
public class PagingController {

	@RequestMapping("/")
	public String index(Model model) {
		return "main";
	}
}
