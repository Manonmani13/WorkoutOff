package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.Department;
import com.pro.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService  departmentService;
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department depart)
	{
	return departmentService.saveDepartment(depart);	 
	}
}
