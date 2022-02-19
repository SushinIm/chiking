package com.sosam.hiking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosam.hiking.model.Culture;
import com.sosam.hiking.model.CultureRepo;
import com.sosam.hiking.service.CultureService;

@Service("cultureService")
public class CultureServiceImpl implements CultureService {

	private CultureRepo cultureRepo;
	
	@Override
	public List<Culture> findBymCode(String mCode) {
		return null;
	}

}
