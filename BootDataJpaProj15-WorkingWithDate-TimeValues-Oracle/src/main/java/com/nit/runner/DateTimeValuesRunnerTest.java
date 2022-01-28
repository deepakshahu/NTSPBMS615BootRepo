package com.nit.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.PersonInfo;
import com.nit.service.IPersonInfoMgmtService;

@Component
public class DateTimeValuesRunnerTest implements CommandLineRunner {
	
	@Autowired
	private IPersonInfoMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		PersonInfo info = new PersonInfo();
		info.setPname("Deepak");
		info.setPage(25.0f);
		info.setDob(LocalDate.of(1996, 4, 15));
		info.setTob(LocalDateTime.of(1996, 4, 15, 7, 54));
		info.setDoj(LocalDateTime.of(2021, 5, 25, 11, 30));
		System.out.println(service.registerPerson(info));
		System.out.println("-----------------------------------");
		service.fetchAllPersonDetails().forEach(System.out::println);
	}//run
}//class