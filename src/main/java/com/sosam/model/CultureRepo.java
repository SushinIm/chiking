package com.sosam.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CultureRepo extends JpaRepository<Culture, String> {
	Culture findBymCode(String mCode);
}
