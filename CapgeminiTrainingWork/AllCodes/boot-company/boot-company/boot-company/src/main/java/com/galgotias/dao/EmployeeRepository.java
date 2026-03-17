package com.galgotias.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.galgotias.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	

	@Query("from Employee e where e.name=:name")
	Employee findByName(String name);
}
