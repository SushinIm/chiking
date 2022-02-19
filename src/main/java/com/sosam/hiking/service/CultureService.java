package com.sosam.hiking.service;

import java.util.List;

import com.sosam.hiking.model.Culture;

public interface CultureService{

	List<Culture> findBymCode(String mCode);

}
