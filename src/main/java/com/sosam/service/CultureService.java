package com.sosam.service;

import java.util.List;

import com.sosam.model.Culture;

public interface CultureService{

	List<Culture> findBymCode(String mCode);

}
