package com.phyho.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiBoardController {
	
	@GetMapping("/multiboard")
	public String index() {
		return "multiboard";
	}
	
}
