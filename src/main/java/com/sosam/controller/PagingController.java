package com.sosam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sosam.model.Mountain;
import com.sosam.service.CultureService;
import com.sosam.service.HikeRoadService;
import com.sosam.service.MountainService;

@Controller
@RequestMapping("/ch")
public class PagingController {

	@Autowired
	MountainService mountainService;
	@Autowired
	HikeRoadService hikeRoadService;
	@Autowired
	CultureService cultureService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "content/main";
	}
	
	@RequestMapping(value = "/lists", method = RequestMethod.GET)
	public String mntn(Model model, String keyword) {
		model.addAttribute("keyword", keyword);
		return "content/mntnLst";
	}

	@RequestMapping(value = "/detail/{mCode}", method = RequestMethod.GET)
	public String dtl(Model model, @PathVariable String mCode) {
		model.addAttribute("mntn", this.mountainService.findById(mCode).get());
		model.addAttribute("rList", this.hikeRoadService.findAllBymcode(mCode).get());
		model.addAttribute("cList", this.cultureService.findAllBymcode(mCode).get());
		return "content/mntnDtl";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String signIn(HttpSession session) {
		if(session.getAttribute("ssui") != null){
			return "redirect:/ch/my-page";
		}
		return "content/signin";
	}

	@RequestMapping(value = "/id-pw", method = RequestMethod.GET)
	public String findPage(HttpSession session) {
		if(session.getAttribute("ssui") != null){
			return "redirect:/ch/my-page";
		}
		return "content/findUser";
	}

	@RequestMapping(value = "/my-page", method = RequestMethod.GET)
	public String myPage(HttpSession session) {
		if(session.getAttribute("ssui") == null){
			return "redirect:/ch/users";
		}
		return "content/myPage";
	}

	@RequestMapping(value = "/newcomer", method = RequestMethod.GET)
	public String newComer(HttpSession session) {
		if(session.getAttribute("ssui") != null){
			return "redirect:/ch/my-page";
		}
		return "content/signup";
	}
}
