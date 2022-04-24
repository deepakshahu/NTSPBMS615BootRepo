package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map, @RequestParam("type") String type) {
		//Use service
		List<Employee> empsList = service.getAllEmployees();
		//add results to model attribute
		map.put("empsList", empsList);
		//return LVN based on the hyperlink that is clicked
		if(type.equalsIgnoreCase("excel"))
			return "excel_report";
		else
			return"pdf_report";
	}
}
