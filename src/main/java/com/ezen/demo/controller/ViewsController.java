package com.ezen.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {
/*
 * GET, POST, PUT, PATCH, DELETE
 */
	
	@GetMapping("/")
	public String home() {
		return "views/index";
	}

	@GetMapping("/views/**")
	public void goPage() {
		
	}
}
