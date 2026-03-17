package com.galgotias.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.galgotias.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	@Query("from Department d where d.name=:name")
	Department findByName(String name);
}
