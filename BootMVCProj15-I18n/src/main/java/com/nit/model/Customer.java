package com.nit.model;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String caddrs;
	private Float billAmount;
}
