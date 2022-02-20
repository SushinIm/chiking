package com.sosam.service;

import java.util.List;

import com.sosam.model.HikeRoad;

public interface HikeRoadService {

	List<HikeRoad> findBymCode(String mCode);

}
