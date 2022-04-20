package com.nit.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.service.IWishService;

@Controller
public class WishMessageOperationsController {
	
	@Autowired
	private IWishService service;

	@GetMapping("/")
	public String showHomePage(HttpSession ses) {
		System.out.println("WishMessageOperationsController.showHomePage()");
		return "welcome";
	}
	
	@GetMapping("/wish")
	public String fetchWishMessage(Map<String,Object> map) {  //Best
		System.out.println("Shared Memory object class name :: "+map.getClass());
		//use service
		String msg = service.generateWishMessage();
		//keep data in model attributes
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		return "show_results";
	}
	
	@GetMapping("/report")
	public String showReport() throws Exception {
		System.out.println("WishMessageOperationsController.showReport()");
		return "show_report";
	}
	
	@PostMapping("/report")
	public String showReport1() throws Exception {
		System.out.println("WishMessageOperationsController.showReport1()");
		return "show_report";
	}
	
}
