package com.sosam.hiking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MainController {
	
	@GetMapping(value = {"/", "/ch"})
	public void index(HttpServletResponse response) throws IOException {
		response.sendRedirect("content/main.html");
	}
	
	@GetMapping("/ch/info/mountains")
	public void infos(HttpServletResponse response) throws IOException {
		response.sendRedirect("content/hundred.html");
	}
	
	@GetMapping("/ch/statistics/rain")
	public void rain(HttpServletResponse response) throws IOException {
		response.sendRedirect("content/rain.html");
	}

	@GetMapping("/ch/statistics/fire")
	public void fire(HttpServletResponse response)throws IOException {
		response.sendRedirect("content/fire.html");
	}
}
