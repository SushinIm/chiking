package com.sosam.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.Like;
import com.sosam.model.User;
import com.sosam.service.LikeService;
import com.sosam.service.UserService;

@RestController
@RequestMapping("/ch/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	LikeService likeService;

	//아이디 중복체크
	@GetMapping("/{uid}")
	public ResponseEntity<String> checkId(@PathVariable String uid) {
		if(userService.checkId(uid)) {
			return ResponseEntity.ok("s");
		}else {
			return ResponseEntity.badRequest().body("f");
		}
	}
	
	//아이디 찾기
	@GetMapping("/id")
	public String findId(String uname) {
		Optional<User> user = userService.findId(uname);
		if(user.isPresent()) {
			return uname + "님의 아이디는 " + user.get().getUid() + "입니다";
		}
		return "해당하는 이름을 가진 유저가 없습니다";
	}

	//비밀번호 찾기
	@GetMapping("/pwd")
	public ResponseEntity<String> findPw(String uid, String uname) {
		if(userService.findPw(uid, uname)) {
			return ResponseEntity.ok("s");
		}else {
			return ResponseEntity.badRequest().body("f");
		}
	}
	
	//비밀번호 변경
	@PostMapping("/pwd")
	public ResponseEntity<String> changePw(String uid, String upw) {
		boolean exist = userService.checkId(uid);
		if(!exist) {
			User user = userService.changePw(uid, upw);
			if(user.getUname() != null) {
				return ResponseEntity.ok("s");
			}else {
				return ResponseEntity.badRequest().body("f");
			}
		}else {
			return ResponseEntity.badRequest().body("e");
		}
	}

	//회원정보 수정
	@PutMapping("/user")
	public ResponseEntity<String> changeInfo(User newUser) {
		if(userService.signUp(newUser)) {
			return ResponseEntity.ok("s");
		}
		return ResponseEntity.badRequest().body("f");
	}

	//회원정보 삭제
	@DeleteMapping("/user")
	public ResponseEntity<String> delUser(HttpSession session) {
		if(userService.delUser((User)session.getAttribute("ssui"))) {
			return ResponseEntity.ok("s");
		}
		return ResponseEntity.badRequest().body("f");
	}
	
	//좋아요 클릭
	@PutMapping("/dib/{mcode}/{uid}")
	public ResponseEntity<Like> likeClick(@PathVariable String mcode, @PathVariable String uid, String flag) {
		Like like = likeService.likeClick(mcode, uid, flag);
		if(like != null) {
			return ResponseEntity.ok(like);
		}
		return ResponseEntity.badRequest().build();
	}
	
	//회원가입
	@PostMapping("/newcomer")
	public ResponseEntity<String> signUp(User user) {
		if(userService.signUp(user)) {
			return ResponseEntity.ok("s");
		}else {
			return ResponseEntity.badRequest().body("f");	
		}
	}

	//로그인
	@PostMapping("/user/{uid}")
	public String signIn(@PathVariable String uid, String upw, HttpServletRequest req) {
		return userService.signIn(uid, upw, req);
	}

	//로그아웃
	@GetMapping("/x")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "로그아웃 되었습니다.";
	}
}
