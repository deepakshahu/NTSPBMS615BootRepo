package com.nit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "SP_DATA_MOVIE")
@RequiredArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MID")
	private Integer mid;
	@Column(name = "MNAME", length=20)
	@NonNull
	private String mname;
	@Column(name = "YEAR", length=20)
	@NonNull
	private String year;
	@Column(name = "RATING")
	@NonNull
	private Float rating;
}