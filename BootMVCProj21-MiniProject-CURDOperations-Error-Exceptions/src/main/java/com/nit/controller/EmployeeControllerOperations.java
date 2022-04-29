package com.nit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		System.out.println("EmployeeControllerOperations.showEmployeeReport()");
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
	
	/*@PostMapping("/add_employee")
	public String addEmployee(Map<String,Object> map, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeControllerOperations.addEmployee()");
		//use service
		String result = empService.registerEmployee(emp);
		List<Employee> list = empService.getAllEmployees();
		//keep results in model attribute
		map.put("resultMsg", result);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}*/
	
	/*@PostMapping("/add_employee")
	public String addEmployee(Map<String,Object> map, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeControllerOperations.addEmployee()");
		//use service
		String result = empService.registerEmployee(emp);
		//keep results in model attribute
		map.put("resultMsg", result);
		//return LVN
		return "redirect:report";
	}*/

	@PostMapping("/add_employee")
	public String addEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeControllerOperations.addEmployee()");
		//use service
		String result = empService.registerEmployee(emp);
		//keep results in model attribute(RedirectAttributes)
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:report";
	}
	
	/*@PostMapping("/add_employee")
	public String addEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeControllerOperations.addEmployee()");
		//use service
		String result = empService.registerEmployee(emp);
		//keep results in session attribute
		ses.setAttribute("resultMsg", result);
		//return LVN
		return "redirect:report";
	}*/

	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		//get Employee details dynamically based on the given emp no
		Employee emp1 = empService.getEmployeeByNo(no);
		//emp=emp1
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
	}

	/*@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp, Map<String,Object> map) {
		//Use service
		String msg = empService.editEmployee(emp);
		List<Employee> list = empService.getAllEmployees();
		//keep the results in model attributes
		map.put("resultMsg", msg);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}*/
	
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
		//Use service
		String msg = empService.editEmployee(emp);
		//keep the results as flashAttribute in redirect scope
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}

	/*@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, Map<String,Object> map) {
		//use service
		String msg = empService.deleteEmployee(no);
		List<Employee> list = empService.getAllEmployees();
		//keep the results in model attributes
		map.put("resultMsg", msg);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}*/
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, RedirectAttributes attrs) {
		//use service
		String msg = empService.deleteEmployee(no);
		//keep the results as flashAttribute in redirect scope
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}

}
