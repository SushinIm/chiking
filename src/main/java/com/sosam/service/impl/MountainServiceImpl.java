package com.sosam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sosam.model.Mountain;
import com.sosam.model.MountainRepo;
import com.sosam.service.MountainService;

@Service("mountainService")
public class MountainServiceImpl implements MountainService{

	private MountainRepo mountainRepo;
	
	public MountainServiceImpl(MountainRepo mountainRepo){
		this.mountainRepo = mountainRepo;
	}
	
	@Override
	public List<Mountain> findBymNameContains(String mName) {
		return this.mountainRepo.findBymNameContains(mName);
	}

	@Override
	public Optional<Mountain> findById(String mCode) {
		return this.mountainRepo.findById(mCode);
	}

	@Override
	public List<Mountain> findAll() {
		return this.mountainRepo.findAll();
	}
	
}
