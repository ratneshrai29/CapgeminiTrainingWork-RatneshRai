package com.galgotias.service;

import java.util.List;

import com.galgotias.model.Employee;

public interface EmployeeService {
	Employee find(int id);
	Employee findByName(String name);
	List<Employee> findAll();
	void addEmployee(Employee emp);
	void  updateEmployeeId(Employee emp);
	void deleteEmployee(int id);
}
