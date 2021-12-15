package com.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
