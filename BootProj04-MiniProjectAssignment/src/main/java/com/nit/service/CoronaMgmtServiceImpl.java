package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.ICoronaDAO;
import com.nit.model.Corona;

@Service("empService")
public class CoronaMgmtServiceImpl implements ICoronaMgmtService {
	@Autowired
	private ICoronaDAO dao;

	@Override
	public List<Corona> fetchPatientsByCities(String city1, String city2, String city3) throws Exception {
		
		//Use DAO
		List<Corona> listPatients = dao.getPatientByCities(city1, city2, city3);
		return listPatients;
	}
}