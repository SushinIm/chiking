package com.sosam.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MountainRepo extends JpaRepository<Mountain, String>{

	//List<Mountain> findByFilter(String mntnname, String mntnaddr, String mntnhigh, String routes);
	
	@Override
	@EntityGraph(attributePaths = {"mrmappings"})
	Optional<Mountain> findById(String mntnid);
}
