package com.nit.dao;

import java.util.List;

import com.nit.model.Corona;

public interface ICoronaDAO {
	
	public List<Corona> getPatientByCities(String city1, String city2, String city3) throws Exception;
}