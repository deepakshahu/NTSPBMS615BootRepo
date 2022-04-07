package com.nit.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nit.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);  //checks whether we are passing correct model class or not
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()(server side form validations)");
		//type casting
		Employee emp = (Employee) target;
		//form validation logics
		if(emp.getEname()==null || emp.getEname().length()==0 || emp.getEname().equals(""))  //ename required rule
			errors.rejectValue("ename", "empname.required");
		else if(emp.getEname().length()>10)                                    //ename maxlength rule
			errors.rejectValue("ename", "empname.maxlength");
		
		if(emp.getJob()==null || emp.getJob().length()==0 || emp.getJob().equals(""))  //job required rule
			errors.rejectValue("job", "empdesg.required");
		else if(emp.getJob().length()>9)                                    //job maxlength rule
			errors.rejectValue("job", "empdesg.maxlength");
		
		if(emp.getSal()==null)  //sal required rule
			errors.rejectValue("sal", "empsal.required");
		else if(emp.getSal()<1 || emp.getSal()>100000)        // sal range check
			errors.rejectValue("sal", "empsal.range");
	}

}
