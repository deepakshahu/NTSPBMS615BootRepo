package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IExamResult {
	
	private Integer id;
	private String dob;
	private Integer semester;
	private Float percentage;
}
