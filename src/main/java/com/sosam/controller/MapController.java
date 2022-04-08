package com.sosam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sosam.model.Mountain;
import com.sosam.service.MapService;

@Controller
@RequestMapping("/ch/detail")
public class MapController {

	@Autowired
	private MapService mapService;
	
	@RequestMapping(value = "/{mntnid}", method = RequestMethod.GET)
	public String dtl(Model model, @PathVariable String mntnid) {
		String page;
		Optional<Mountain> mntn = this.mapService.findMountain(mntnid);
		
		if(mntn.isPresent()) {
			model.addAttribute("mntn", mntn.get());
			page = "content/mntnDtl"; 
		}else {
			model.addAttribute("msg", "에러가 발생했습니다.");
			page = "errors/fail";
		}
		return page;
	}
}
