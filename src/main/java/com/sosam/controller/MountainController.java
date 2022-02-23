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
@RequestMapping("/sg/mntn")
public class MountainController {
	
	@Autowired
	MountainService mountainService;
	
	@GetMapping("/mountains")
	public List<Mountain> search(String mName) {
		return ("".equals(mName)) ? this.mountainService.findAll() : this.mountainService.findBymNameContains(mName);
	}
	
	@GetMapping("/filter")
	public ResponseEntity<Optional<List<Mountain>>> mntnFilter(MountainJoin mj) throws Exception {
		Optional<List<Mountain>> mntnList = this.mountainService.mntnFilter(mj);
		if(mntnList != null) {
			return ResponseEntity.ok(mntnList);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{mCode}")
	public ResponseEntity<Optional<Mountain>> mntnDtl(@PathVariable String mCode) {
		Optional<Mountain> mntn = this.mountainService.findById(mCode);
		if(mntn.isPresent()) {
			return ResponseEntity.ok(mntn);
		}
		return ResponseEntity.badRequest().build();
	}
	
}
