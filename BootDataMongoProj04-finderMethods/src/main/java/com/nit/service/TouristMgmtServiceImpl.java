package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.document.Tourist;
import com.nit.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public List<Tourist> fetchTouristsByNativePlaceAscOrder(String nativePlace) {
		return touristRepo.findByNativePlaceOrderByTouristNameAsc(nativePlace);
	}
	
	@Override
	public Tourist fetchTouristsByContactNo(Long contactNo) {
		return touristRepo.findByContactNo(contactNo);
	}
	
}