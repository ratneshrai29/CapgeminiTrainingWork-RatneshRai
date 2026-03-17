package com.galgotias.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galgotias.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Component
public class DepartmentDaoImplements implements DepartmentDao{
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public Department find(int id) {
		EntityManager em =  emf.createEntityManager();
		Department department = em.find(Department.class,id);
		return department;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDepartment(Department dep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartmentId(Department dep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
