package com.sosam.service.impl;

import java.util.List;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sosam.model.Mountain;
import com.sosam.model.MountainJoin;
import com.sosam.model.MountainRepo;
import com.sosam.model.mapper.MountainMapper;
import com.sosam.service.MountainService;

@Service("mountainService")
public class MountainServiceImpl implements MountainService{
	
	private MountainRepo mountainRepo;
	
	@Autowired
	private MountainMapper mountainMapper;
	
	public MountainServiceImpl(MountainRepo mountainRepo){
		this.mountainRepo = mountainRepo;
	}
	
	@Override
	public List<Mountain> findBymNameContains(String mName) {
		return this.mountainRepo.findBymnameContains(mName);
	}
	
	@Override
	public Optional<Mountain> findById(String mCode) {
		return this.mountainRepo.findById(mCode);
	}

	@Override
	public List<Mountain> findAll() {
		return this.mountainRepo.findAll();
	}
	
	@Override
	public List<MountainJoin> mntnFilter(MountainJoin mj) throws Exception{  
		List<MountainJoin> mntnList = this.mountainMapper.mntnFilter(mj);
		return mntnList;
	}  
}
