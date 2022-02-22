package com.sosam.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MountainRepo extends JpaRepository<Mountain, String>{

	List<Mountain> findBymnameContains(String mName);

	Optional<Mountain> findBymcode(String mCode);
}
