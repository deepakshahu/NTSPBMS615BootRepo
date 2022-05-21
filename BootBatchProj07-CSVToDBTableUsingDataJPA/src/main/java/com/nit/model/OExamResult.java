package com.nit.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUPER_TOP_BRAINS")
public class OExamResult {
	@Id
	private Integer id;
	private LocalDate dob;
	private Integer semester;
	private Float percentage;
}
