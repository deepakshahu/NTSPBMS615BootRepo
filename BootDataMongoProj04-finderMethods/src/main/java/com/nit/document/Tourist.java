package com.nit.document;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "tourist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist implements Serializable{
	@Id
	private String Id;
	private String touristName;
	private String nativePlace;
	private Float age;
	private String passportNo;
	private Long contactNo;
	private Boolean isVaccinated;
	private Integer visaDuration;
	private LocalDateTime visaExpiry;
}