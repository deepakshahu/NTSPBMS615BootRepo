package com.nit.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
//@Data
@PropertySource("classpath:input.properties")
public class Hospital {
	
	@Value("KIMS")  //hard coding
	private String name;
	
	@Value("30")  //hard coding
	private int rank;
	
	@Value("${hsptl.name}")   //collecting from properties file
	private String name1;
	
	@Value("${hsptl.age}")  //collecting from properties file
	private int age;
	
	@Value("${Path}")  //injecting from environment variable
	private String pathData;
	
	@Value("${os.name}")  //injecting from system property value
	private String os;
	
	/*//@Autowired  //Autowiring
	@Value("#{ltinfo}")  //Using SPEL performing injection to object property
	private LabTestsInfo info;
	
	@Value("#{ltinfo.bloodProfilePrice+ltinfo.rtpcrPrice}")  //SPEL based arithmetic operation and injection
	private float labTestsBillAmt;*/

	@Override
	public String toString() {
		return "Hospital [name=" + name + ", rank=" + rank + ", name1=" + name1 + ", age=" + age + ", pathData="
				+ pathData + ", os=" + os; //+ ", info=" + info + ", labTestsBillAmt=" + labTestsBillAmt + "]";
	}
}
