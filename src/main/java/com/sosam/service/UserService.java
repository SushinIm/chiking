package com.sosam.service;

import javax.servlet.http.HttpServletRequest;

import com.sosam.model.User;

public interface UserService {
	
	String signIn(String uId, String uPw, HttpServletRequest req);

	User signUp(User user);

	String checkId(String uId);
}
