package com.sosam.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RouteRepo extends JpaRepository<Route, RouteIds> {

	Optional<List<Route>> findAllByrouteid(String routeid);

}
