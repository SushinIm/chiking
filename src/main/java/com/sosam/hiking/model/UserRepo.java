package com.sosam.hiking.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, String>{

	Optional<User> findByuname(String uname);

	Optional<User> findByuidAndUname(String uid, String uname);
	
}
