package com.nit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Employee> fetchEmpDetailsByDesgs(String desg1, String desg2) {
		//Create StoredProcedureQuery object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_EMPS_BY_JOB", Employee.class);
		//Register Parameters with JDBC Types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		//Set values to IN parameters
		query.setParameter(1, desg1);
		query.setParameter(2, desg2);
		//Call the PL/SQL Procedure and get the Result
		List<Employee> list = query.getResultList();
		return list;
	}//method
}//class