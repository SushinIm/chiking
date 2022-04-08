package com.sosam.service;

import java.util.List;

import com.sosam.model.FilterVo;
import com.sosam.model.MountainJoin;

public interface SearchService {

	List<MountainJoin> mntnFilter(FilterVo f) throws Exception;

}
