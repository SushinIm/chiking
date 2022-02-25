package com.sosam.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosam.model.User;
import com.sosam.model.UserRepo;
import com.sosam.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public boolean checkId(String uid) {
		if(this.userRepo.findById(uid).isEmpty()) {
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean signUp(User user) {
		String uid = user.getUid();
		if(userRepo.findById(uid).isPresent()) {
			return false;
		}
		String rawPw = user.getUpw();
		user.setUpw(passwordEncoder.encode(rawPw));
		User resultUser = userRepo.save(user);
		if(resultUser != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public String signIn(String uid, String upw, HttpServletRequest req){
		Optional<User> user = this.userRepo.findById(uid);
		HttpSession session = req.getSession();		// 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
		if(user.isPresent()) {
			if(passwordEncoder.matches(upw, user.get().getUpw())) {
				// 로그인 성공 처리
				user.get().setUpw("");
				session.setAttribute("ssui", user.get());   // 세션에 로그인 회원 정보 보관
				return "s";
			}
		}
		return "f";
	}

	@Override
	public Optional<User> findId(String uname) {
		return userRepo.findByuname(uname);
	}

	@Override
	public boolean findPw(String uid, String uname) {
		return userRepo.findByuidAndUname(uid, uname).isPresent();
	}

	@Override
	public User changePw(String uid, String upw) {
		User user = userRepo.findById(uid).get();
		user.setUpw(passwordEncoder.encode(upw));
		return userRepo.save(user);
	}

	@Override
	public boolean delUser(User user) {
		if(user != null) {
			userRepo.delete(user);
			return true;
		}
		return false;
	}
	
}
