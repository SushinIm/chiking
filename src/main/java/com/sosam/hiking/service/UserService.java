package com.sosam.hiking.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sosam.hiking.model.User;

public interface UserService {
	
	String signIn(String uid, String upw, HttpServletRequest req);

	boolean signUp(User user);

	Optional<User> checkId(String uid);

	Optional<User> findId(String uname);

	boolean findPw(String uid, String uname);

	User changePw(String uid, String upw);

	boolean delUser(User user);

	boolean checkPw(String uid, String upw);

	boolean userUpdate(HttpSession session, User newUser);

}
