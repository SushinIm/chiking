package com.sosam.hiking.service;

import java.util.List;
import java.util.Optional;

import com.sosam.hiking.model.Marker;
import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.model.Route;

public interface MapService {

	Optional<Mountain> findMountain(String mntnid);

	Optional<List<Route>> findRoute(String routeid);

	Optional<List<Marker>> findMarker(String routeid);

}
