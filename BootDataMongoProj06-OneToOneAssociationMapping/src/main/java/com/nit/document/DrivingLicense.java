package com.nit.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(collection = "DrivingLicense")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class DrivingLicense {
	@Id
	@NonNull
	private Long licenseNo;
	@NonNull
	private String type;
	@NonNull
	private LocalDate expiryDate;
	private Person personDetails;
	
	@Override
	public String toString() {
		return "DrivingLicense [licenseNo=" + licenseNo + ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}

}