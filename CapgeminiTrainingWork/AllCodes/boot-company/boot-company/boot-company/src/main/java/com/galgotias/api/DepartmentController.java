package com.galgotias.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.galgotias.model.Department;
import com.galgotias.service.DepartmentService;

//@Controller
@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService depService;
	
	@RequestMapping("/department/{id}")
	@ResponseBody
	public Department getDepartment(@PathVariable("id") int id) {
		Department department = depService.find(id);
		return department;
	}
	
	@GetMapping("/department")
	public  Department getDepartmentById(@RequestParam("id") int id) {
		Department department = depService.find(id);
		return department;
	}
	
	@GetMapping("/department/byname")
	public  Department getDepartmentByName(@RequestParam("name") String name) {
		Department department = depService.findByName(name);
		return department;
	}

}
