package com.sosam.service;

import java.util.List;
import java.util.Optional;

import com.sosam.model.Mountain;

public interface MountainService {

	List<Mountain> findBymNameContains(String mName);

	Optional<Mountain> findById(String mCode);

	List<Mountain> findAll();

}
