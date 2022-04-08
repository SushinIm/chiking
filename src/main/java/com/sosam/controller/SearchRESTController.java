package com.sosam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.FilterVo;
import com.sosam.model.MountainJoin;
import com.sosam.service.SearchService;

@RestController
@RequestMapping("/ch/search")
public class SearchRESTController {

	@Autowired
	private SearchService searchService;
	
	@GetMapping("/mountains")	//산 목록 조회
	public ResponseEntity<List<MountainJoin>> mntnFilter(FilterVo f) throws Exception {
		List<MountainJoin> mntnList = this.searchService.mntnFilter(f);
		if(mntnList != null) {
			return ResponseEntity.ok(mntnList);
		}
		return ResponseEntity.notFound().build();
	}
	
}
