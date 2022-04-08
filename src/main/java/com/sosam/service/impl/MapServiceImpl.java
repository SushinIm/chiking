package com.sosam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sosam.model.Mountain;
import com.sosam.model.MountainRepo;
import com.sosam.model.Route;
import com.sosam.model.RouteRepo;

@Service("mapService")
public class MapServiceImpl implements com.sosam.service.MapService {

	private MountainRepo mountainRepo;
	
	private RouteRepo routeRepo;
	
	public MapServiceImpl(MountainRepo mountainRepo, RouteRepo routeRepo){
		this.mountainRepo = mountainRepo;
		this.routeRepo = routeRepo;
	}

	@Override
	public Optional<Mountain> findMountain(String mntnid) {
		return this.mountainRepo.findById(mntnid);
	}

	@Override
	public Optional<List<Route>> findRoute(String routeid) {
		return this.routeRepo.findAllByrouteid(routeid);
	}

}
