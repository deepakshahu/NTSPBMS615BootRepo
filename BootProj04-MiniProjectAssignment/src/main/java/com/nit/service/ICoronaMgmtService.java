package com.nit.service;

import java.util.List;

import com.nit.model.Corona;

public interface ICoronaMgmtService {
	public List<Corona> fetchPatientsByCities(String city1, String city2, String city3) throws Exception;
}
