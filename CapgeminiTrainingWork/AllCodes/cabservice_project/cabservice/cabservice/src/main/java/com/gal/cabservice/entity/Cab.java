package com.gal.cabservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class Cab {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	Long Id;
	String cabName;
	boolean cabStatus;
	
	public Cab(){}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCabName() {
		return cabName;
	}
	public void setCabName(String cabName) {
		this.cabName = cabName;
	}
	public boolean isCabStatus() {
		return cabStatus;
	}
	public void setCabStatus(boolean cabStatus) {
		this.cabStatus = cabStatus;
	}
	
}
