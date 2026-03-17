package com.galgotias.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="managerId")
	int mid;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int mid) {
		super();
		this.id = id;
		this.name = name;
		this.mid=mid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mid=" + mid + "]";
	}
	
	
	
	
	
}
