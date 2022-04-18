package com.sosam.hiking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ch")
public class UserController {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String signIn(HttpSession session) {
		if(session.getAttribute("ssui") != null){
			return "redirect:/ch/my-page";
		}
		return "content/signin";
	}

	@RequestMapping(value = "/id-pw", method = RequestMethod.GET)
	public String findPage(HttpSession session) {
		if(session.getAttribute("ssui") != null){
			return "redirect:/ch/my-page";
		}
		return "content/findUser";
	}

	@RequestMapping(value = "/my-page", method = RequestMethod.GET)
	public String myPage(HttpSession session) {
		if(session.getAttribute("ssui") == null){
			return "redirect:/ch/users";
		}
		return "content/myPage";
	}

	@RequestMapping(value = "/newcomer", method = RequestMethod.GET)
	public String newComer(HttpSession session) {
		if(session.getAttribute("ssui") != null){
			return "redirect:/ch/my-page";
		}
		return "content/signup";
	}
}
