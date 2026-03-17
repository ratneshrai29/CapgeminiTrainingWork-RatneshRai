package com.galgotias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galgotias.dao.EmployeeRepository;
import com.galgotias.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Employee find(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
	}

	@Override
	public void updateEmployeeId(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
