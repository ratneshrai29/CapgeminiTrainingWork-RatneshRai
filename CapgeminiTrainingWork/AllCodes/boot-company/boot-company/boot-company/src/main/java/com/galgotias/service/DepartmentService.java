package com.galgotias.service;

import java.util.List;

import com.galgotias.model.Department;

public interface DepartmentService {
	
	Department find(int id);
	Department findByName(String name);
	List<Department> findAll();
	void addDepartment(Department dep);
	void  updateDepartmentId(Department dep);
	void deleteDepartment(int id);
}
