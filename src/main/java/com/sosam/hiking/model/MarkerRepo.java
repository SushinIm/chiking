package com.sosam.hiking.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkerRepo extends JpaRepository<Marker, String> {

	Optional<List<Marker>> findAllByrouteid(String routeid);

}
