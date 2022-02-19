package com.sosam.hiking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sosam.hiking.model.UserRepo;
import com.sosam.hiking.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
}
