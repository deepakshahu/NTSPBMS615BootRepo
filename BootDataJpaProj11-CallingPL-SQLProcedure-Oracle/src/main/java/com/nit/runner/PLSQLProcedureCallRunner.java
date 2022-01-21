package com.nit.runner;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*CREATE OR REPLACE PROCEDURE PRO_AUTHENTICATION 
(
  USER IN VARCHAR2 
, PASS IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
  CNT NUMBER;
BEGIN
  SELECT COUNT(*) INTO CNT FROM USERINFO WHERE UNAME=USER AND PWD=PASS;
  IF(CNT<>0)THEN
    RESULT:='VALID CREDENTIALS';
  ELSE
    RESULT:='INVALID CREDENTIALS';
  END IF;
END PRO_AUTHENTICATION;*/

@Component
public class PLSQLProcedureCallRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		//Create Stored Procedure Query object representing the given PL/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("PRO_AUTHENTICATION");
		//Register parameters of PL/SQL procedure with java types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		//Set values to IN parameters
		query.setParameter(1, "deepak");
		query.setParameter(2, "shahu");
		//Call PL/SQL procedure
		String result = (String) query.getOutputParameterValue(3);
		System.out.println("Authentication :: "+result);
	}//run(-)
}//class