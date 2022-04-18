package com.sosam.hiking.service;

import java.util.List;
import java.util.Optional;

import com.sosam.hiking.model.FilterVo;
import com.sosam.hiking.model.Mountain;

public interface SearchService {

	Optional<List<Mountain>> mntnFilter(FilterVo f) throws Exception;

}
