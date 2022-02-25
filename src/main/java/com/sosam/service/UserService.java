package com.sosam.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.sosam.model.User;

public interface UserService {
	
	String signIn(String uid, String upw, HttpServletRequest req);

	boolean signUp(User user);

	boolean checkId(String uid);

	Optional<User> findId(String uname);

	boolean findPw(String uid, String uname);

	User changePw(User user, String upw);

	boolean delUser(User user);

}
