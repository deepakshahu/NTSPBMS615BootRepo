package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDAO")
public class EmployeeDAO {
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	@Autowired
	private DataSource ds;  //HAS-A property
	
	//Method with persistence logic
	public int getEmpsCount() throws Exception{
		System.out.println("Injected DataSource object class name: "+ds.getClass());
		
		//Get Pooled JDBC con object
		Connection con = ds.getConnection();
		
		//Create PreparedStatement object having sql query
		PreparedStatement ps = con.prepareStatement(GET_EMPS_COUNT);
		
		//Execute the query
		ResultSet rs = ps.executeQuery();
		
		//Process the ResultSet
		rs.next();
		int count = rs.getInt(1);
		
		//Close jdbc con object
		rs.close();
		ps.close();
		con.close();
		
		return count;
	}//method
}//class