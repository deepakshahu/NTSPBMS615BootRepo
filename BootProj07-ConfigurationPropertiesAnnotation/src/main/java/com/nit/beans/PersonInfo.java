package com.nit.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("pInfo")
@ConfigurationProperties(prefix="per.info")
public class PersonInfo {
	//Simple/Wrapper type
	private Integer pid;
	private String pname;
	
	//Array type
	private String[] favColors;
	
	//List-Collection type
	private List<String> studies;
	
	//Set-Collection type
	private Set<Long> phoneNumbers;
	
	//Map-Collection type
	private Map<String,Object> idDetails;
	
	//HAS-A type (Composition)
	private JobDetails jobInfo; 
}
