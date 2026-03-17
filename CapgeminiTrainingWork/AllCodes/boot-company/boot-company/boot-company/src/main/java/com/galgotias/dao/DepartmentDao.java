package com.galgotias.dao;

import java.util.List;

import com.galgotias.model.Department;

public interface DepartmentDao  {
	
	Department find(int id);
	List<Department> findAll();
	void addDepartment(Department dep);
	void  updateDepartmentId(Department dep);
	void deleteDepartment(int id);
}
