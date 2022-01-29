package com.nit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="person_info_lob")
public class PersonInfo implements Serializable{
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length=20)
	private String pname;
	private LocalDateTime dob;
	private boolean married;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
}
