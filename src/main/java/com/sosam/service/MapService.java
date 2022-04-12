package com.sosam.service;

import java.util.List;
import java.util.Optional;

import com.sosam.model.Marker;
import com.sosam.model.Mountain;
import com.sosam.model.Route;

public interface MapService {

	Optional<Mountain> findMountain(String mntnid);

	Optional<List<Route>> findRoute(String routeid);

	Optional<List<Marker>> findMarker(String routeid);

}
