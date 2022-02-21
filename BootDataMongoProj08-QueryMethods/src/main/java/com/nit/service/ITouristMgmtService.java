package com.nit.service;

import java.util.List;

import com.nit.document.Tourist;

public interface ITouristMgmtService {
	
	public List<Tourist> fetchAllTouristsByNativePlace(String nativePlace);
	public List<Tourist> fetchAllTouristsByNativePlaceAndAge(String nativePlace, float minAge);
	public List<Tourist> fetchAllTouristsByAgeRange(float startAge, float endAge);
	public List<Tourist> fetchAllTouristsByNativePlaces(String nativePlace1, String nativePlace2);
	public List<Object[]> fetchTouristDataByNativePlace(String nativePlace);
	public List<Object[]> fetchTouristDataByNativePlaces(String nativePlace1, String nativePlace2, String nativePlace3);
}