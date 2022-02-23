package com.sosam.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sosam.model.Culture;
import com.sosam.model.HikeRoad;
import com.sosam.model.Mountain;
import com.sosam.service.CultureService;
import com.sosam.service.HikeRoadService;
import com.sosam.service.MountainService;

@Controller
@RequestMapping("/sg")
public class PagingController {

	@Autowired
	MountainService mountainService;
	@Autowired
	HikeRoadService hikeRoadService;
	@Autowired
	CultureService cultureService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/lists", method = RequestMethod.GET)
	public String mntn(Model model, String mName) {
		model.addAttribute("mName", mName);
		return "content/mntnLst";
	}

	@RequestMapping(value = "/detail/{mCode}", method = RequestMethod.GET)
	public String dtl(Model model, @PathVariable String mCode) {
		model.addAttribute("mntn", this.mountainService.findById(mCode));
		model.addAttribute("rList", this.hikeRoadService.findBymCode(mCode));
		model.addAttribute("cList", this.cultureService.findBymCode(mCode));
		return "content/mntnDtl";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String signIn(Model model) {
		return "content/login";
	}
}
