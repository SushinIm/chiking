package com.sosam.hiking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.service.MountainService;

@Service
public class MountainServiceImpl implements MountainService{

	@Override
	public List<Mountain> findBymName(String mName) {
		return null;
	}

	@Override
	public Mountain findBymCode(String mCode) {
		return null;
	}

}
