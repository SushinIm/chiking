package com.sosam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.Culture;
import com.sosam.service.CultureService;

@RestController
@RequestMapping("/sg/cult")
public class CultureController {

	@Autowired
	CultureService cultureService;
	
	@GetMapping("/cultures/{mCode}")
	public List<Culture> cultLst(@PathVariable String mCode){
		return cultureService.findBymCode(mCode);
	}
	
}