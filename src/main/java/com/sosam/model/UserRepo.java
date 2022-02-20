package com.sosam.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String>{
	User findByuId(String uId);
}
