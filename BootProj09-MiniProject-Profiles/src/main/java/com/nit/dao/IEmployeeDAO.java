package com.nit.dao;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception;
}
