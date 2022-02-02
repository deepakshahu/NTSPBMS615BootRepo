//Child class
package com.nit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="AM_PHONENUMBERS_DETAILS")
public class PhoneNumber implements Serializable{
	@Id
	@GeneratedValue
	Integer regNo;
	private Long contactNo;
	@Column(length=20)
	private String numberType;
	@Column(length=20)
	private String provider;
	//taking property for FK column of any db table is optional
	
	@Override
	public String toString() {
		return "PhoneNumber(child) [regNo=" + regNo + ", phoneNumber=" + contactNo + ", numberType=" + numberType
				+ ", provider=" + provider + "]";
	}
}