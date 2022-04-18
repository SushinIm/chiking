package com.sosam.hiking.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MountainRepo extends JpaRepository<Mountain, String>, JpaSpecificationExecutor<Mountain>{

	@Override
	@EntityGraph(attributePaths = {"mrmappings"})
	Optional<Mountain> findById(String mntnid);

}
