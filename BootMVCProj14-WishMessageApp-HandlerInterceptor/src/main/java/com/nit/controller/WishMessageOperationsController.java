package com.nit.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nit.service.IWishService;

@Controller
public class WishMessageOperationsController {
	
	@Autowired
	private IWishService service;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("WishMessageOperationsController.showHomePage()");
		return "home";
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

}
