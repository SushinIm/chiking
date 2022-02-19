package com.sosam.hiking.service;

import java.util.List;

import com.sosam.hiking.model.Mountain;

public interface MountainService {

	List<Mountain> findBymName(String mName);

	Mountain findBymCode(String mCode);

}
