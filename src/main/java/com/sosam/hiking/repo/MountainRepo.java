package com.sosam.hiking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sosam.hiking.dto.Mountain;

public interface MountainRepo extends JpaRepository<Mountain, String>{

}
