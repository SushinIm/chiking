package com.sosam.hiking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sosam.hiking.dto.HikeRoad;

public interface HikeRoadRepo extends JpaRepository<HikeRoad, String>{

}
