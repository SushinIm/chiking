package com.sosam.hiking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sosam.hiking.model.FilterVo;
import com.sosam.hiking.model.Mountain;
import com.sosam.hiking.model.MountainRepo;
import com.sosam.hiking.model.MountainSpecification;
import com.sosam.hiking.service.SearchService;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private MountainRepo mountainRepo;
	
	@Override
	public Optional<List<Mountain>> mntnFilter(FilterVo f) throws Exception{
		Specification<Mountain> spec = Specification.where(MountainSpecification.likeMntnname(f.getKeyword()));
	    if(f.getMntnaddr() != null) {
	    	spec = spec.and(MountainSpecification.likeMntnaddr(f.getMntnaddr()));
	    }
	    if(f.getMntnhigh1() != 0 && f.getMntnhigh2() != 0) {
	    	spec = spec.and(MountainSpecification.betweenMntnhighs(f.getMntnhigh1(), f.getMntnhigh2()));
	    }
	    if(f.getRoute1() != 0) {
	    	if(f.getRoute2() == 0) {
	    		spec = spec.and(MountainSpecification.greaterThanRoutes(f.getRoute1()));
	    	}else {
	    		spec = spec.and(MountainSpecification.betweenRoutes(f.getRoute1(), f.getRoute2()));
	    	}
	    }

	    Optional<List<Mountain>> mntnList = Optional.ofNullable(this.mountainRepo.findAll(spec));
		return mntnList;
	}
}
