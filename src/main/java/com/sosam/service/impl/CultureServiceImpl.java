package com.sosam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sosam.model.Culture;
import com.sosam.model.CultureRepo;
import com.sosam.model.Mountain;
import com.sosam.service.CultureService;

@Service("cultureService")
public class CultureServiceImpl implements CultureService {

	private CultureRepo cultureRepo;
	
	public CultureServiceImpl(CultureRepo cultureRepo) {
		this.cultureRepo = cultureRepo;
	}
	
	@Override
	public Optional<List<Culture>> findAllBymcode(String mCode) {
		return cultureRepo.findAllBymcodeAndCdetailNotLike(mCode, "-");
	}

}
