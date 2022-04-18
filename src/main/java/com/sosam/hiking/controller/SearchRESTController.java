package com.sosam.hiking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.hiking.model.FilterVo;
import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.service.SearchService;

@RestController
@RequestMapping("/ch/search")
public class SearchRESTController {

	@Autowired
	private SearchService searchService;
	
	@GetMapping("/mountains")	//산 목록 조회
	public ResponseEntity<List<Mountain>> mntnFilter(FilterVo f) throws Exception {
		Optional<List<Mountain>> mntnList = this.searchService.mntnFilter(f);
		if(mntnList.isPresent()) {
			return ResponseEntity.ok(mntnList.get());
		}
		return ResponseEntity.notFound().build();
	}
	
}
