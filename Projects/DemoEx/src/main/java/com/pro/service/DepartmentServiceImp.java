package com.pro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pro.model.Department;
import com.pro.repository.DepartmentRepository;

public class DepartmentServiceImp implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;


	@Override
	public Department saveDepartment(Department depart) {
		// TODO Auto-generated method stub
		return departmentRepository.save(depart);
	}
	
}
