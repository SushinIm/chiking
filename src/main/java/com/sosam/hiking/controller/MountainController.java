package com.sosam.hiking.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.service.impl.MountainServiceImpl;

@RestController
@RequestMapping("/sg/mntn")
public class MountainController {
	
	@Autowired
	MountainServiceImpl mountainService;
	
	@GetMapping("/mountains")
	public List<Mountain> search(String mName) {
		return mountainService.findBymName(mName);
	}

	@GetMapping("/{mCode}")
	public Mountain mntnDtl(@PathVariable String mCode) {
		return mountainService.findBymCode(mCode);
	}
	
}
