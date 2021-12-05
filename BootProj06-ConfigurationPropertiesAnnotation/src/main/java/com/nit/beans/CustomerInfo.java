package com.nit.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("custInfo")
@ConfigurationProperties(prefix="cust.info")
@Data
public class CustomerInfo {
	//Spring bean properties
	private String name;
	private int age;
	private String addrs;
	private float billAmt;

}