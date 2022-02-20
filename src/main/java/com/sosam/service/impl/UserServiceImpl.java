package com.sosam.service.impl;

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
	
	@Transactional
    public void encryptPassword(String userPw){
        User user = User.builder().build();
        String enPw = passwordEncoder.encode(userPw);
        user.setUPw(enPw);
        userRepo.save(user);
    }
	
	public Boolean login(String uId, String rawPw){
		// 이 함수는 user repository에 따로 구현이 되어 있어야 한다. 
		User user = userRepo.findByuId(uId);
	    if(passwordEncoder.matches(rawPw, user.getUPw())){
	    	return true;
	    } else{
	    	return false;
	    }
	}
}
