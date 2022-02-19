package com.sosam.hiking.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sg")
public class PagingController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		//model.addAttribute("data", "hello!!");
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
