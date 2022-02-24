package com.sosam.service;

import java.util.List;
import java.util.Optional;

import com.sosam.model.Culture;
import com.sosam.model.Mountain;

public interface CultureService{

	Optional<List<Culture>> findAllBymcode(String mCode);

}
