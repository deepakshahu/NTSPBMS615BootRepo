package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Corona;
import com.nit.service.ICoronaMgmtService;

@Controller("controller")
public class CoronaController {
	@Autowired
	private ICoronaMgmtService service;
	
	public List<Corona> showPatientsByCities(String city1, String city2, String city3) throws Exception{
		
		//Use service class
		List<Corona> listPatients = service.fetchPatientsByCities(city1, city2, city3);
		return listPatients;
	}
}
