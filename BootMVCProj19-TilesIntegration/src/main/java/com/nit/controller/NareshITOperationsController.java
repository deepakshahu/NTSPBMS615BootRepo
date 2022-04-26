package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NareshITOperationsController {
	
	@GetMapping("/")
	public String showHomePage() {
		return "homePageDef";
	}
	
	@GetMapping("/facultyurl")
	public String showFacultiesPage() {
		return "facultiesPageDef";
	}
	
	@GetMapping("/courseurl")
	public String showCoursePage() {
		return "coursesPageDef";
	}
	
	@GetMapping("/aboutUsurl")
	public String showAboutUsPage() {
		return "aboutUsPageDef";
	}
}
