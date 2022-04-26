package com.sosam.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.User;
import com.sosam.service.UserService;

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
