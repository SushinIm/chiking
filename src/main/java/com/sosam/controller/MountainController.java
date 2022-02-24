package com.sosam.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.Mountain;
import com.sosam.model.MountainJoin;
import com.sosam.service.MountainService;

@RestController
@RequestMapping("/ch/mntn")
public class MountainController {
	
	@Autowired
	MountainService mountainService;
	
	@GetMapping("/mountains")
	public ResponseEntity<List<MountainJoin>> mntnFilter(MountainJoin mj) throws Exception {
		List<MountainJoin> mntnList = this.mountainService.mntnFilter(mj);
		if(mntnList != null) {
			return ResponseEntity.ok(mntnList);
		}
		return ResponseEntity.notFound().build();
	}
	
	/*
	 * @GetMapping("/{mCode}") public ResponseEntity<Optional<Mountain>>
	 * mntnDtl(@PathVariable String mCode) { Optional<Mountain> mntn =
	 * this.mountainService.findById(mCode); if(mntn.isPresent()) { return
	 * ResponseEntity.ok(mntn); } return ResponseEntity.badRequest().build(); }
	 */
}
