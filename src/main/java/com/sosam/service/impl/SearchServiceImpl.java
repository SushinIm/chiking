package com.sosam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sosam.model.FilterVo;
import com.sosam.model.MountainJoin;
import com.sosam.model.mapper.MountainMapper;
import com.sosam.service.SearchService;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private MountainMapper mountainMapper;
	
	@Override
	public List<MountainJoin> mntnFilter(FilterVo f) throws Exception{
		List<MountainJoin> mntnList = this.mountainMapper.mntnFilter(f);
		return mntnList;
	}
}
