package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.comm.Manager;
import com.example.demo.comm.ResponseTemplate;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;

@Autowired
RestTemplate restTemplate;

public Employee saveEmployee(Employee employee) {
	// TODO Auto-generated method stub
	return employeeRepository.save(employee);
}

//public Employee getByEmployeeId(long empId) {
//return employeeRepository.findByEmpId(empId);
//}

public ResponseTemplate getByEmployeeWithManagerId(long empId) {
	ResponseTemplate responseTemplate=new ResponseTemplate(); 
	
	Employee emp=employeeRepository.getByEmpId(empId);
	Manager manager=restTemplate.getForObject("http://localhost:8088/managers/"+ emp.getManagerId(),Manager.class);
	responseTemplate.setEmployee(emp);
	responseTemplate.setManager(manager);
	return responseTemplate;
}



}
