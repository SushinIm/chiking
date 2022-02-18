package com.sosam.hiking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sosam.hiking.dto.Culture;

public interface CultureRepo extends JpaRepository<Culture, String>{

}
