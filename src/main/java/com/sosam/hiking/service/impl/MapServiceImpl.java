package com.sosam.hiking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sosam.hiking.model.Marker;
import com.sosam.hiking.model.MarkerRepo;
import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.model.MountainRepo;
import com.sosam.hiking.model.Route;
import com.sosam.hiking.model.RouteRepo;
import com.sosam.hiking.service.MapService;

@Service("mapService")
public class MapServiceImpl implements MapService {

	private MountainRepo mountainRepo;
	
	private RouteRepo routeRepo;
	
	private MarkerRepo markerRepo;
	
	public MapServiceImpl(MountainRepo mountainRepo, MarkerRepo markerRepo, RouteRepo routeRepo){
		this.mountainRepo = mountainRepo;
		this.markerRepo = markerRepo;
		this.routeRepo = routeRepo;
	}

	@Override
	public Optional<Mountain> findMountain(String mntnid) {
		return mountainRepo.findById(mntnid);
	}

	@Override
	public Optional<List<Route>> findRoute(String routeid) {
		return routeRepo.findAllByrouteid(routeid);
	}

	@Override
	public Optional<List<Marker>> findMarker(String routeid) {
		return markerRepo.findAllByrouteid(routeid);
	}
}
