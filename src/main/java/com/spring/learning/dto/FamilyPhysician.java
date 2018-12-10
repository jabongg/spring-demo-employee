package com.spring.learning.dto;

import javax.persistence.Entity;

@Entity
public class FamilyPhysician extends Doctor {

	private Boolean givesAdvice;

	public Boolean getGivesAdvice() {
		return givesAdvice;
	}

	public void setGivesAdvice(Boolean givesAdvice) {
		this.givesAdvice = givesAdvice;
	}
	
	
}
