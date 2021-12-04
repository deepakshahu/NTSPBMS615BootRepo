package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Corona;

@Repository("coronaDAO")
public class CoronaDAOImpl implements ICoronaDAO {
	private static final String GET_PATIENTS_BY_CITIES = "SELECT CNO,CPNAME,CITY,STATUS,TEMP FROM CORONA WHERE CITY IN (?,?,?) ORDER BY CITY";
	@Autowired
	private DataSource ds;

	@Override
	public List<Corona> getPatientByCities(String city1, String city2, String city3) throws Exception {
		List<Corona> listPatients = null;
		System.out.println("DataSource Object Class Name: "+ds.getClass());

		try(//Get Pooled JDBC Connection object
				Connection con = ds.getConnection();
				//Create Prepared Statement object
				PreparedStatement ps = con.prepareStatement(GET_PATIENTS_BY_CITIES)){
			//Set query parameter values
			ps.setString(1, city1);
			ps.setString(2, city2);
			ps.setString(3, city3);
			//Send and execute SQL query in DB s/w
			try(ResultSet rs = ps.executeQuery()){
				//Convert ResultSet objects records to List of Model class objects
				listPatients = new ArrayList<Corona>();
				Corona c = null;
				while(rs.next()) {
					//Copy each record of rs to a object of Employee class
					c = new Corona();
					c.setCno(rs.getInt(1));
					c.setCpname(rs.getString(2));
					c.setCity(rs.getString(3));
					c.setStatus(rs.getString(4));
					c.setTemp(rs.getFloat(5));
					
					//Add each object of Employee to List Collection
					listPatients.add(c);
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
		return listPatients;
	}//method
}//class