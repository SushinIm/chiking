package com.sosam.service;

import java.util.List;
import java.util.Optional;

import com.sosam.model.Culture;

public interface CultureService{

	Optional<List<Culture>> findBymCode(String mCode);

}
