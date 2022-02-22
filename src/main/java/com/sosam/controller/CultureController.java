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
import com.sosam.service.CultureService;

@RestController
@RequestMapping("/sg/cult")
public class CultureController {

	@Autowired
	CultureService cultureService;
	
	@GetMapping("/{mCode}")
	public ResponseEntity<Optional<List<Culture>>> cultLst(@PathVariable String mCode){
		Optional<List<Culture>> cList = cultureService.findBymCode(mCode);
		if(cList.isPresent()) {
			return ResponseEntity.ok(cList);
		}
		return ResponseEntity.badRequest().build();
	}
	
}