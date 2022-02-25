package com.sosam.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.sosam.model.User;

public interface UserService {
	
	String signIn(String uId, String uPw, HttpServletRequest req);

	boolean signUp(User user);

	boolean checkId(String uId);

	Optional<User> findId(String uname);

	boolean findPw(String uId);

	User changePw(User user, String uPw);

	boolean delUser(User user);

}
