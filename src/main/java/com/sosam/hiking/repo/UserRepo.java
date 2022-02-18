package com.sosam.hiking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sosam.hiking.dto.User;

public interface UserRepo extends JpaRepository<User, String>{

}
