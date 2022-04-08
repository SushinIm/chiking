package com.sosam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.Route;
import com.sosam.service.MapService;

@RestController
@RequestMapping("/ch/map")
public class MapRESTController {

	@Autowired
	private MapService mapService;
	
	@GetMapping("/{routeid}")
	public ResponseEntity<List<Route>> routes(@PathVariable String routeid){
		Optional<List<Route>> routes = mapService.findRoute(routeid);
		if(routes.isPresent()) {
			return ResponseEntity.ok(routes.get());
		}
		return ResponseEntity.notFound().build();
	}
}
