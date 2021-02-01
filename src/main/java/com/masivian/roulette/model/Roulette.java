package com.masivian.roulette.model;

import java.io.Serializable;

public class Roulette implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Status status;
	public Integer getId() {
		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Status getStatus() {
		
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
