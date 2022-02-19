package com.sosam.hiking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosam.hiking.model.HikeRoad;
import com.sosam.hiking.model.HikeRoadRepo;
import com.sosam.hiking.service.HikeRoadService;

@Service("hikeRoadService")
public class HikeRoadServiceImpl implements HikeRoadService{

	private HikeRoadRepo hikeRoadRepo;
	
	@Override
	public List<HikeRoad> findBymCode(String mCode) {
		return null;
	}
	
}
