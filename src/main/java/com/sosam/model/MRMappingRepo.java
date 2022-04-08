package com.sosam.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MRMappingRepo extends JpaRepository<MRMapping, String> {

	//Optional<List<MRMapping>> findAllBymntnid(String mntnid);

}
