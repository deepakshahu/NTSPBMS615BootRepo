package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.document.PersonInfo;

public interface IPersonInfoMgmtService {
	public String registerPerson(PersonInfo info);
	public List<PersonInfo> fetchAllPersons();
	public String savePersonGroup(List<PersonInfo> info);
	public List<PersonInfo> fetchAllPersons(boolean asc, String ...properties);
	public Optional<PersonInfo> fetchPersonById(Integer id);
	public String modifyPersonInfoById(Integer id, List<String> friends);
	public String removePersonInfoById(Integer id);
}
