package com.nit.service;

import java.util.List;

public interface IOneToManyMappingMgmtService {
	public List<Object[]> fetchDataByJoins();
}