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
	public String checkId(String uId) {
		if(this.userRepo.findById(uId).isEmpty()) {
			return "사용 가능한 아이디입니다.";
		}
		return "이미 존재하는 아이디입니다.";
	}
	
	@Override
	@Transactional
	public User signUp(User user) {
		String rawPw = user.getUpw();
		user.setUpw(passwordEncoder.encode(rawPw));
		return userRepo.save(user);
	}
	
	@Override
	public String signIn(String uId, String uPw, HttpServletRequest req){
		Optional<User> user = this.userRepo.findById(uId);
		HttpSession session = req.getSession();		// 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
		if(user.isPresent()) {
			if(passwordEncoder.matches(uPw, user.get().getUpw())) {
				// 로그인 성공 처리
				user.get().setUpw("");
				session.setAttribute("loginUser", user.get());   // 세션에 로그인 회원 정보 보관
				return "성공";
			}
		}
		return "실패";
	}

	@Override
	public String findId(String uName) {
		return userRepo.findByuname(uName);
	}

	@Override
	public boolean findPw(String uId) {
		return userRepo.findById(uId).isPresent();
	}

	@Override
	public User changePw(User user, String uPw) {
		user.setUpw(passwordEncoder.encode(uPw));
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
