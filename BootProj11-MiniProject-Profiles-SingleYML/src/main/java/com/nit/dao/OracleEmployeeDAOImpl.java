package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("oraEmpDAO")
@Profile({"uat","prod"})
public class OracleEmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DEGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;
	
	public OracleEmployeeDAOImpl() {
		System.out.println("OracleEmployeeDAOImpl :: 0-param constructor");
	}

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("OracleEmployeeDAOImpl.getEmpsByDesgs()"+ds.getClass());
		List<Employee> listEmps = null;

		try (//Get Pooled JDBC Connection object
				Connection con = ds.getConnection();
				//Create PreparedStatement object
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DEGS);
				){
			//Set query parameter values
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			//Send and execute SQL Query in DB s/w
			try(ResultSet rs = ps.executeQuery()){
				//Convert ResultSet objects records to List of Model class objects
				listEmps = new ArrayList<Employee>();
				Employee emp = null;
				while(rs.next()) {
					//Copy each record of rs to a object of Employee class
					emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSal(rs.getFloat(4));
					//Add each object of Employee to List Collection
					listEmps.add(emp);
				}//while
			}//try2
		}//try1 RS, ST, con object will be closed here automatically because of try with resource concept
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  //exception re-throwing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //exception re-throwing
		}
		return listEmps;
	}//method
}//class