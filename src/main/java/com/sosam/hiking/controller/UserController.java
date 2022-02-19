package com.sosam.hiking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.hiking.service.impl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userService;
}
