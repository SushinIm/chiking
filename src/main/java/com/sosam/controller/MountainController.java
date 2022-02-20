package com.sosam.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.Mountain;
import com.sosam.service.impl.MountainServiceImpl;

@RestController
@RequestMapping("/sg/mntn")
public class MountainController {
	
	@Autowired
	MountainServiceImpl mountainService;
	
	@GetMapping("/mountains")
	public List<Mountain> search(String mName) {System.out.println(mName);
		return ("".equals(mName)) ? this.mountainService.findAll() : this.mountainService.findBymNameContains(mName);
	}

	@GetMapping("/{mCode}")
	public ResponseEntity<?> mntnDtl(@PathVariable String mCode) {
		Optional<Mountain> mntn = this.mountainService.findById(mCode);
		if(mntn.isPresent()) {
			return ResponseEntity.ok(mntn);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
}
