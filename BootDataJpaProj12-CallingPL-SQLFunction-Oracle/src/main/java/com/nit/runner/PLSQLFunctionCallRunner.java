package com.nit.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import oracle.jdbc.internal.OracleTypes;

/*create or replace FUNCTION FX_GET_MOVIES_BY_RATINGS 
(
  START_RATING IN NUMBER 
, END_RATING IN NUMBER 
, CNT OUT NUMBER 
) RETURN SYS_REFCURSOR AS 
    DETAILS SYS_REFCURSOR;
BEGIN
  SELECT COUNT(*) INTO CNT FROM SP_DATA_MOVIE;
    OPEN DETAILS FOR
      SELECT MNAME,RATING,YEAR FROM SP_DATA_MOVIE WHERE RATING>=START_RATING AND RATING<=END_RATING;
  RETURN DETAILS;
END FX_GET_MOVIES_BY_RATINGS;*/

@Component
public class PLSQLFunctionCallRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		//Unwrap Session object from EntityManager Object
		Session ses = manager.unwrap(Session.class);
		//Work with ReturningWork<T> callback interface based Callback method
		Object results[] = ses.doReturningWork(con->{
			//Write Callback Statement based logic to call PL/SQL function
			CallableStatement cs = con.prepareCall("{?=call FX_GET_MOVIES_BY_RATINGS(?,?,?)}");
			//register return(1), out params(4) with jdbc types
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.registerOutParameter(4, Types.INTEGER);
			//Set values to IN parameter
			cs.setFloat(2, 4.0f);
			cs.setFloat(3, 5.5f);
			//Call PL/SQL function
			cs.execute();
			//Gather results from out parameters
			ResultSet rs = (ResultSet) cs.getObject(1);
			List<Object[]> list = new ArrayList();
			while(rs.next()) {
				Object record[] = 	new Object[3];
				record[0] = rs.getString(1);
				record[1] = rs.getString(2);
				record[2] = rs.getString(3);
				list.add(record);
			}//while
			Object data[] = new Object[2];
			data[0] = list;
			data[1] = cs.getInt(4);  //out param cnt value
			return data;
		});

		//Process the result
		System.out.println("Movies in ratings range are :: ");
		List<Object[]> ratingsList = (List<Object[]>) results[0];
		ratingsList.forEach(md->{
			for(Object val:md)
				System.out.print(val+" ");
			System.out.println();
		});

		//Get count of records
		int count = (int) results[1];
		System.out.println("Records count :: "+count);
	}//run(-)
}//class