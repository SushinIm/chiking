package com.sosam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@GetMapping("/{uId}")
	public ResponseEntity<String> checkId(@PathVariable String uId) {
		if(userService.checkId(uId)) {
			return ResponseEntity.ok("s");
		}else {
			return ResponseEntity.badRequest().body("f");
		}
	}
	
	//아이디 찾기
	@GetMapping("/id")
	public String findId(String uName) {
		return userService.findId(uName);
	}

	//비밀번호 찾기
	@GetMapping("/pwd")
	public ResponseEntity<String> findPw(String uId) {
		if(userService.findPw(uId)) {
			return ResponseEntity.ok("s");
		}else {
			return ResponseEntity.badRequest().body("f");
		}
	}
	
	//비밀번호 변경
	@PutMapping("/pwd")
	public ResponseEntity<User> changePw(HttpSession session, String uPw) {
		if(session.getAttribute("ssui") != null) {
			User user = userService.changePw((User)session.getAttribute("ssui"), uPw);
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.badRequest().build();
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
	@PutMapping("/dib/{mCode}/{uId}")
	public ResponseEntity<Like> likeClick(@PathVariable String mCode, @PathVariable String uId, String flag) {
		Like like = likeService.likeClick(mCode, uId, flag);
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
	@PostMapping("/user/{uId}")
	public String signIn(@PathVariable String uId, String uPw, HttpServletRequest req) {
		return userService.signIn(uId, uPw, req);
	}

	//로그아웃
	@GetMapping("/x")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "로그아웃 되었습니다.";
	}
}
