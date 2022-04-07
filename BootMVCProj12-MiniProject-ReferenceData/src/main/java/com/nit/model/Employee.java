package com.nit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name = "emp")
@SQLDelete(sql = "UPDATE EMP SET STATUS='inactive' WHERE EMPNO=?")
@Where(clause = "STATUS <> 'inactive' ")
public class Employee implements Serializable{
	
	@Id
	@SequenceGenerator(name="gen1", sequenceName = "emp_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	private String status = "active";
	@Transient
	private String vflag="no";
	private String country;
	private String state;
	private String gender;
	private String hb[] = new String[] {"Swimming","Workout"};
	private String courses[] = new String[] {"Core Java","Spring"};
}
