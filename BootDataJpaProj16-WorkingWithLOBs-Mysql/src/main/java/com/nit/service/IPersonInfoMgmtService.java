package com.nit.service;

import com.nit.entity.PersonInfo;

public interface IPersonInfoMgmtService {
	public String registerPerson(PersonInfo info);
	public PersonInfo fetchPersonDetailsById(int pid);
}