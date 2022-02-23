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
@RequestMapping("/sg/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	LikeService likeService;

	//아이디 중복체크
	@GetMapping("/{uId}")
	public String checkId(@PathVariable String uId) {
		return userService.checkId(uId);
	}
	
	//아이디 찾기
	@GetMapping("/id")
	public String findId(String uName) {
		return userService.findId(uName);
	}

	//비밀번호 찾기
	@GetMapping("/pwd")
	public String findPw(String uId) {
		if(userService.findPw(uId)) {
			return "새로운 비밀번호를 입력하세요.";
		}
		return "해당 아이디가 존재하지 않습니다.";
	}
	
	//비밀번호 변경
	@PutMapping("/pwd")
	public ResponseEntity<User> changePw(HttpSession session, String uPw) {
		if(session.getAttribute("loginUser") != null) {
			User user = userService.changePw((User)session.getAttribute("loginUser"), uPw);
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

	//회원정보 수정
	@PutMapping("/user")
	public ResponseEntity<User> changeInfo(User newUser) {
		User user = userService.signUp(newUser);
		if(user != null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.badRequest().build();
	}

	//회원정보 수정
	@DeleteMapping("/user")
	public ResponseEntity<String> delUser(HttpSession session) {
		boolean isDelete = userService.delUser((User)session.getAttribute("loginUser"));
		if(isDelete) {
			return ResponseEntity.ok("회원 탈퇴 되었습니다.");
		}
		return ResponseEntity.badRequest().body("로그인 후 이용바랍니다.");
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
	public ResponseEntity<User> signUp(User user) {
		User result = userService.signUp(user);
		if(result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}

	//로그인
	@PostMapping("/user/{uId}")
	public String signIn(@PathVariable String uId, String uPw, HttpServletRequest req) {
		return userService.signIn(uId, uPw, req);
	}

	//로그아웃
	@GetMapping("/users/x")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "로그아웃 되었습니다.";
	}
}
