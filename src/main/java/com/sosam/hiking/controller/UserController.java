package com.sosam.hiking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.hiking.service.UserService;

@RestController
@RequestMapping("/sg/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String login() {
		return null;
	}
}
