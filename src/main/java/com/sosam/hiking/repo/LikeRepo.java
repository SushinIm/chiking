package com.sosam.hiking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sosam.hiking.dto.Like;

public interface LikeRepo extends JpaRepository<Like, String>{

}
