package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.document.Tourist;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourists();
	public String saveTouristGroup(List<Tourist> tourists);
	public List<Tourist> fetchAllTourists(boolean asc, String ...properties);
	public Optional<Tourist> fetchTouristById(String id);
	public String modifyTouristById(String id, long contactNo);
	public String removeTouristById(String id);
}