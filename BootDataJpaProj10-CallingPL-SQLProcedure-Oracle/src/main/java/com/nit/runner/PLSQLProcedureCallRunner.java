package com.nit.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.model.Movie;

@Component
public class PLSQLProcedureCallRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		//Create StoredProcedure Query object representing the given PL/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_MOVIES_BY_YEAR_RANGE", Movie.class);
		//Register parameters of PL/SQL procedure with java types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Movie.class, ParameterMode.REF_CURSOR);
		//Set values to IN params
		query.setParameter(1, "1900");
		query.setParameter(2, "2021");
		//Call PL/SQL procedure
		List<Movie> list = query.getResultList();
		list.forEach(System.out::println);
		
	}//run(-)
}//class