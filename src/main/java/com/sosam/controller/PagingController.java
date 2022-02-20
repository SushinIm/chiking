package com.sosam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sg")
public class PagingController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/lists", method = RequestMethod.GET)
	public String mntn(Model model, String mName) {
		model.addAttribute("mName", mName);
		return "content/mntnLst";
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String dtl(Model model) {
		return "content/mntnDtl";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String login(Model model) {
		return "content/login";
	}
}
