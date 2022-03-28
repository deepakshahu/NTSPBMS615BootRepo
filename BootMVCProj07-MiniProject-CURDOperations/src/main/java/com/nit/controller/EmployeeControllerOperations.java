package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;

@Controller
public class EmployeeControllerOperations {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String,Object> map) {
		//Use service
		List<Employee> list = empService.getAllEmployees();
		//put the result in model attributes
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}

	@GetMapping("/add_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		emp.setJob("CLERK");  //initial value to display in form comp
		//return LVN
		return "employee_register";
	}

	@PostMapping("/add_employee")
	public String addEmployee(Map<String,Object> map, @ModelAttribute("emp") Employee emp) {
		//use service
		String result = empService.registerEmployee(emp);
		List<Employee> list = empService.getAllEmployees();
		//keep results in model attribute
		map.put("resultMsg", result);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}

	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		//get Employee details dynamically based on the given emp no
		Employee emp1 = empService.getEmployeeByNo(no);
		//emp=emp1
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
	}

	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp, Map<String,Object> map) {
		//Use service
		String msg = empService.editEmployee(emp);
		List<Employee> list = empService.getAllEmployees();
		//keep the results in model attributes
		map.put("resultMsg", msg);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, Map<String,Object> map) {
		//use service
		String msg = empService.deleteEmployee(no);
		List<Employee> list = empService.getAllEmployees();
		//keep the results in model attributes
		map.put("resultMsg", msg);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}

}
