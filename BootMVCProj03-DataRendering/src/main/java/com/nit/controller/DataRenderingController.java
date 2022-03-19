package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nit.model.Product;

@Controller
public class DataRenderingController {
	
	/*@GetMapping("/report")
	public String showReportData(Map<String,Object> map) {
		//Add simple values as the model attributes
		map.put("name", "raja");
		map.put("age", 30);
		map.put("addrs", "hyd");
		//Return LVN
		return "show_report";
	}*/
	
	/*@GetMapping("/report")
	public String showReportData(Map<String,Object> map) {
		//Add Array,Collection values as the model attributes
		//Generally these values are not hardcoded static values-these values will come from DB s/w through DAO,Service class
		map.put("favColors", new String[] {"red","green","yellow","white"});
		map.put("nickNames", List.of("raja","maharaja","king","prince"));
		map.put("phoneNumbers", Set.of(99999999L,88888888L,777777777L,6666666666L));
		map.put("idDetails", Map.of("aadhar",869228376887L,"voterId", 7854694, "panNo", "GHLPS631C"));
		//Return LVN
		return "show_report";
	}*/
	
	/*@GetMapping("/report")
	public String showReportData(Map<String,Object> map) {
		//Add Model class object as the model attributes
		//Create Model class object having data (generally this object comes from DAO, service classes) having db table record
		Product prod = new Product(1001,"Sofa", 54000.78, 1.0);
		//Make model class object as the model attributes
		map.put("prodData", prod);
		//Return LVN
		return "show_report";
	}*/
	
	@GetMapping("/report")
	public String showReportData(Map<String,Object> map) {
		//Create list of model class object as the model attributes
		List<Product> list = List.of(new Product(1001,"Sofa", 56478.02, 1.0), new Product(1002,"Chair",5400.2,5.0));
		map.put("prodList", list);
		//Return LVN
		return "show_report";
	}
}
