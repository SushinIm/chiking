package com.sosam.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosam.model.HikeRoad;
import com.sosam.model.HikeRoadRepo;
import com.sosam.service.HikeRoadService;

@Service("hikeRoadService")
public class HikeRoadServiceImpl implements HikeRoadService{

	private HikeRoadRepo hikeRoadRepo;
	
	public HikeRoadServiceImpl(HikeRoadRepo hikeRoadRepo) {
		this.hikeRoadRepo = hikeRoadRepo;
	}
	
	@Override
	public List<HikeRoad> findBymCode(String mCode) {
		return null;
	}
	
}
