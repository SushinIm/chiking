package com.sosam.hiking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.model.MountainRepo;
import com.sosam.hiking.service.MountainService;

@Service("mountainService")
public class MountainServiceImpl implements MountainService{

	private MountainRepo mountainRepo;
	
	@Override
	public List<Mountain> findBymName(String mName) {
		return null;
	}

	@Override
	public Mountain findBymCode(String mCode) {
		return null;
	}

}
