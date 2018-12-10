package com.spring.learning.dto;

import javax.persistence.Entity;

@Entity
public class Surgeon extends Doctor {

	private Boolean doesSurgery;

	public Boolean getDoesSurgery() {
		return doesSurgery;
	}

	public void setDoesSurgery(Boolean doesSurgery) {
		this.doesSurgery = doesSurgery;
	}
	
	
}
