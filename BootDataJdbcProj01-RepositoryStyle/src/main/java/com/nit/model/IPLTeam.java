package com.nit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Table(name = "DATA_JDBC_IPLTEAM")
@NoArgsConstructor
@AllArgsConstructor
public class IPLTeam implements Persistable<Integer>{
	@Id
	private Integer teamid;
	private String teamname;
	private String captain;
	private String owner;
	private Integer titlewinningcount;
	
	@Override
	public Integer getId() {
		return teamid;
	}
	
	@Transient
	private boolean insertion;
	
	@Override
	public boolean isNew() {
		return insertion;
	}

	@Override
	public String toString() {
		return "IPLTeam [teamid=" + teamid + ", teamname=" + teamname + ", captain=" + captain + ", owner=" + owner
				+ ", titlewinningcount=" + titlewinningcount + "]";
	}
	
}
