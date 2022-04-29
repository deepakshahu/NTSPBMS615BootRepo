package com.nit.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileOperationsController {
	
	@GetMapping("/")
	public String showHome(Map<String,Object> map) {
		map.put("sysDate", LocalDateTime.now());
		map.put("wMsg", "GM");
		return "welcome";
	}
	
}
