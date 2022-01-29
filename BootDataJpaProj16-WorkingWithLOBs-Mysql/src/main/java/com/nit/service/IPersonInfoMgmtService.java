package com.nit.service;

import java.util.List;

import com.nit.entity.PersonInfo;

public interface IPersonInfoMgmtService {
	public String registerPerson(PersonInfo info);
	public List<PersonInfo> fetchAllPersonDetails();
}