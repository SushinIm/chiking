package com.sosam.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CultureRepo extends JpaRepository<Culture, String> {
	Optional<List<Culture>> findBymcode(String mCode);
}
