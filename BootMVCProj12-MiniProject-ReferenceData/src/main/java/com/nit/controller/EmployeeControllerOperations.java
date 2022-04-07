package com.nit.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;
import com.nit.validations.EmployeeValidator;

@Controller
public class EmployeeControllerOperations {

	@Autowired
	private IEmployeeMgmtService empService;
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/report")
	public String showEmployeeReport(@PageableDefault(page=0, size = 3, sort = "job", direction = Sort.Direction.ASC) Pageable pageable, Map<String,Object> map) {
		System.out.println("EmployeeControllerOperations.showEmployeeReport()");
		//Use service
		Page<Employee> page = empService.getEmployeesPageData(pageable);
		//put the result in model attributes
		map.put("empsData", page);
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
	public String addEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		System.out.println("EmployeeControllerOperations.addEmployee()");
		//enable server side form validations only when client side form validations are not done
		if(emp.getVflag().equalsIgnoreCase("no")) {
			//checking for typeMismatch errors
			if(errors.hasFieldErrors())
				return"employee_register";

			//use empValidator  //checking for form validation errors
			if(empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);  
				if(errors.hasErrors())
					return "employee_register";
			}
		}

		//check for application logic error
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_register";
		}
		//use service
		String result = empService.registerEmployee(emp);
		//keep results in model attribute(RedirectAttributes)
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:report";
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
	public String editEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs, BindingResult errors) {
		if(emp.getVflag().equalsIgnoreCase("no")) {
			//checking for typeMismatch errors
			if(errors.hasFieldErrors())
				return "employee_edit";

			//use empValidator  //checking for form validation errors
			if(empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);  
				if(errors.hasErrors())
					return "employee_edit";
			}
		}

		//check for application logic error
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_edit";
		}
		//Use service
		String msg = empService.editEmployee(emp);
		//keep the results as flashAttribute in redirect scope
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, RedirectAttributes attrs) {
		//use service
		String msg = empService.deleteEmployee(no);
		//keep the results as flashAttribute in redirect scope
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}
	
	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries(){
		System.out.println("EmployeeControllerOperations.populateCountries()");
		//use service
		Set<String> countrySet = empService.getAllCountries();
		return countrySet;
	}
	
	@PostMapping("/statesurl")
	public String showStatesByCountry(@RequestParam("country") String country, @ModelAttribute("emp") Employee emp, Map<String,Object> map) {
		System.out.println("EmployeeControllerOperations.showStatesByCountry()");
		//use service
		List<String> statesList = empService.getStatesByCountry(country);
		//put statesList in model attribute
		map.put("statesInfo", statesList);
		//return LVN of form page
		return "employee_register";
	}
	
	@ModelAttribute("hobbiesInfo")
	public Set<String> populateHobbies(){
		System.out.println("EmployeeControllerOperations.populateHobbies()");
		return empService.getAllHobbies();
	}
	
	@ModelAttribute("coursesInfo")
	public Set<String> populateCourses(){
		System.out.println("EmployeeControllerOperations.populateCourses()");
		return empService.getAllCourses();
	}
	
}
