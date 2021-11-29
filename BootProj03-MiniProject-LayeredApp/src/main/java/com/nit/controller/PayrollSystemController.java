package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;

@Controller("controller")
public class PayrollSystemController {
	@Autowired
	private IEmployeeMgmtService service;
	
	public List<Employee> showEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception{
		
		//Use service class
		List<Employee> listEmps = service.fetchEmpsByDesgs(desg1, desg2, desg3);
		return listEmps;
	}
}
