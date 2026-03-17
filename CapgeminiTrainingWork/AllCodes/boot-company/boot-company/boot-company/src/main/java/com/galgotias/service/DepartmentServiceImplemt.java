package com.galgotias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galgotias.dao.DepartmentDao;
import com.galgotias.dao.DepartmentRepository;
import com.galgotias.model.Department;


@Service
public class DepartmentServiceImplemt implements DepartmentService {
	
	DepartmentDao departmentDao;
	@Autowired
	DepartmentRepository repo;
	
	
	@Autowired
	public DepartmentServiceImplemt(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}
	
	

	@Override
	public Department find(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}
	
	@Override
	public Department findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}



	@Override
	public List<Department> findAll() {
		return repo.findAll();
	}

	@Override
	public void addDepartment(Department dep) {
		repo.save(dep);
		
	}

	@Override
	public void updateDepartmentId(Department dep) {
		repo.save(dep);
		
	}

	@Override
	public void deleteDepartment(int id) {
		repo.deleteById(id);
		
	}

	
	

}
