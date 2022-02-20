package com.sosam.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainRepo extends JpaRepository<Mountain, String>{

	List<Mountain> findBymNameContains(String mName);

	Mountain findBymCode(String mCode);
}
