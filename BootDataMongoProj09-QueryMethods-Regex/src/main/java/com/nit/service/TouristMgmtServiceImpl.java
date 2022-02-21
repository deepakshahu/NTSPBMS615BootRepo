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
	public List<Tourist> fetchTouristByNativePlaceWithRegex(String nativePlace) {
		return touristRepo.getTouristByNativePlaceRegex(nativePlace);
	}

	@Override
	public int fetchTouristsCountByAgeRange(float minAge, float maxAge) {
		return touristRepo.getTouristsCountByAgeRange(minAge, maxAge);
	}

	@Override
	public List<Tourist> fetchTouristsSortedByName() {
		return touristRepo.getAllTouristsSortedByName();
	}

	@Override
	public int removeTouristsWithNoContactNumber() {
		return touristRepo.deleteTouristsWithNoContactNumber();
	}

	@Override
	public boolean isThereTouristsWithOutVaccination() {
		return touristRepo.isTouristsExistWithOutVaccination();
	}
	
}
