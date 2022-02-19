package com.sosam.hiking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.hiking.service.impl.CultureServiceImpl;

@RestController
public class CultureController {

	@Autowired
	CultureServiceImpl cultureService;
}
