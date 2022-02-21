package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.document.Tourist;
import com.nit.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepo touristRepo;
	
	@Override
	public List<Tourist> fetchAllTouristsByNativePlace(String nativePlace) {
		return touristRepo.getAllTouristsByNativePlace(nativePlace);
	}

	@Override
	public List<Tourist> fetchAllTouristsByNativePlaceAndAge(String nativePlace, float minAge) {
		return touristRepo.getAllTouristsByNativePlaceAndAge(nativePlace, minAge);
	}

	@Override
	public List<Tourist> fetchAllTouristsByAgeRange(float startAge, float endAge) {
		return touristRepo.getAllTouristsByAgeRange(startAge, endAge);
	}

	@Override
	public List<Tourist> fetchAllTouristsByNativePlaces(String nativePlace1, String nativePlace2) {
		return touristRepo.getAllTouristsByNativePlaces(nativePlace1, nativePlace2);
	}

	@Override
	public List<Object[]> fetchTouristDataByNativePlace(String nativePlace) {
		return touristRepo.getTouristDataByNativePlace(nativePlace);
	}

	@Override
	public List<Object[]> fetchTouristDataByNativePlaces(String nativePlace1, String nativePlace2,
			String nativePlace3) {
		return touristRepo.getTouristDataByNativePlaces(nativePlace1, nativePlace2, nativePlace3);
	}
	
}
