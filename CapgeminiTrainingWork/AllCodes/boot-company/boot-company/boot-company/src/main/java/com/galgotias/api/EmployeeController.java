package com.galgotias.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galgotias.model.Employee;
import com.galgotias.service.EmployeeService;

public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	
	@RequestMapping("/employee/{id}")
	@ResponseBody
	public Employee getDepartment(@PathVariable("id") int id) {
		Employee employee = empService.find(id);
		return employee;
	}
	
	@GetMapping("/employee")
	public Employee getEmployeeById(@RequestParam("id") int id) {
		Employee employee = empService.find(id);
		return employee;
	}
	
	@GetMapping("/employee/byname")
	public Employee getEmployeeByName(@RequestParam("name") String name) {
		Employee employee = empService.findByName(name);
		return employee;
	}

}
