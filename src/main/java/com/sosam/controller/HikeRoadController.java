package com.sosam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.Culture;
import com.sosam.model.HikeRoad;
import com.sosam.service.HikeRoadService;

@RestController
@RequestMapping("/ch/road")
public class HikeRoadController {

	@Autowired
	HikeRoadService hikeRoadService;
	/*
	 * @GetMapping("/{mCode}") public ResponseEntity<Optional<List<HikeRoad>>>
	 * roadLst(@PathVariable String mCode) { Optional<List<HikeRoad>> rList =
	 * hikeRoadService.findBymCode(mCode); if(rList.isPresent()) { return
	 * ResponseEntity.ok(rList); } return ResponseEntity.badRequest().build(); }
	 */
}
