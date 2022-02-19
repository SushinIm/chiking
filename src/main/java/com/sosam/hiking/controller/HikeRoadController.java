package com.sosam.hiking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.hiking.model.HikeRoad;
import com.sosam.hiking.service.HikeRoadService;

@RestController
@RequestMapping("/sg/road")
public class HikeRoadController {

	@Autowired
	HikeRoadService hikeRoadService;
	
	@GetMapping("/roads/{mCode}")
	public List<HikeRoad> roadLst(@PathVariable String mCode) {
		return hikeRoadService.findBymCode(mCode);
	}
}
