package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comm.ResponseTemplate;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController  {
@Autowired
private EmployeeService employeeService;
@PostMapping()
public Employee saveEmployee(@RequestBody Employee employee)
{
return employeeService.saveEmployee(employee);	
}
@GetMapping("/{id}")
public ResponseTemplate getByEmployeeWithManagerId(@PathVariable("id") long empId)
{
	return employeeService.getByEmployeeWithManagerId(empId);
}
}
