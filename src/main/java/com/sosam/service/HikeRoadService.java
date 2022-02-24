package com.sosam.service;

import java.util.List;
import java.util.Optional;

import com.sosam.model.HikeRoad;

public interface HikeRoadService {

	Optional<List<HikeRoad>> findAllBymcode(String mCode);

}
