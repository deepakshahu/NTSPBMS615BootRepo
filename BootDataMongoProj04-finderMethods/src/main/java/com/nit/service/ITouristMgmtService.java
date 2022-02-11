package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.document.Tourist;

public interface ITouristMgmtService {
	
	public List<Tourist> fetchTouristsByNativePlaceAscOrder(String nativePlace);
	public Tourist fetchTouristsByContactNo(Long contactNo);
}