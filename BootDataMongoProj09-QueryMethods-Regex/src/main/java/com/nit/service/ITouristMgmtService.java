package com.nit.service;

import java.util.List;

import com.nit.document.Tourist;

public interface ITouristMgmtService {
	
	public List<Tourist> fetchTouristByNativePlaceWithRegex(String nativePlace);
	public int fetchTouristsCountByAgeRange(float minAge, float maxAge);
	public List<Tourist> fetchTouristsSortedByName();
	public int removeTouristsWithNoContactNumber();
	public boolean isThereTouristsWithOutVaccination();
}