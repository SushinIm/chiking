package com.sosam.hiking.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosam.hiking.model.User;
import com.sosam.hiking.model.UserRepo;
import com.sosam.hiking.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override	//아이디 유뮤 확인
	public Optional<User> checkId(String uid) {
		return this.userRepo.findById(uid);
	}

	@Override	//아이디 찾기
	public Optional<User> findId(String uname) {
		return userRepo.findByuname(uname);
	}

	@Override	//비밀번호 찾기
	public boolean findPw(String uid, String uname) {
		return userRepo.findByuidAndUname(uid, uname).isPresent();
	}
	
	@Override	//비밀번호 일치 확인
	public boolean checkPw(String uid, String upw) {
		Optional<User> user = this.userRepo.findById(uid);
		if(user.isPresent()) {
			if(passwordEncoder.matches(upw, user.get().getUpw())) {
				return true;
			}
		}
		return false;
	}

	@Override	//비밀번호 변경
	public User changePw(String uid, String upw) {
		User user = userRepo.findById(uid).get();
		user.setUpw(passwordEncoder.encode(upw));
		return userRepo.save(user);
	}

	@Override
	@Transactional	//회원정보 수정
	public boolean userUpdate(HttpSession session, User user) {
		String uid = user.getUid();
		Optional<User> before = userRepo.findById(uid);
		if(before.isPresent()) {
			if(user.getUpw() == null) {
				user.setUpw(before.get().getUpw());
			}else {
				user.setUpw(passwordEncoder.encode(user.getUpw()));
			}
			User resultUser = userRepo.save(user);
			if(resultUser != null) {
				session.removeAttribute("ssui");
				session.setAttribute("ssui", resultUser);
				return true;
			}
		}
		return false;
	}

	@Override	//회원탈퇴
	public boolean delUser(User user) {
		if(user != null) {
			userRepo.delete(user);
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional	//회원가입
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
	
	@Override	//로그인
	public String signIn(String uid, String upw, HttpServletRequest req){
		Optional<User> user = this.userRepo.findById(uid);
		HttpSession session = req.getSession();		// 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
		if(user.isPresent()) {
			if(passwordEncoder.matches(upw, user.get().getUpw())) {
				// 로그인 성공 처리
				user.get().setUpw("");
				session.setAttribute("ssui", user.get());   // 세션에 로그인 회원 정보 보관
				return "s";
			}else {
				return "f";
			}
		}else {
			return "e";
		}
	}

}
