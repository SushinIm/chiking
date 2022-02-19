package com.sosam.hiking.service;

import java.util.List;

import com.sosam.hiking.model.HikeRoad;

public interface HikeRoadService {

	List<HikeRoad> findBymCode(String mCode);

}
