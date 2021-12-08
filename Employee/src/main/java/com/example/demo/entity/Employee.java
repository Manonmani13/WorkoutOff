package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="EmployeeTable")
public class Employee {
@Id
private long empId;
private String empName;
private String designation;
private long managerId;

public Employee(long empId, String empName, String designation, long managerId) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.designation = designation;
	this.managerId = managerId;
}

public long getEmpId() {
	return empId;
}

public void setEmpId(long empId) {
	this.empId = empId;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public long getManagerId() {
	return managerId;
}

public void setManagerId(long managerId) {
	this.managerId = managerId;
}

public Employee() {
	super();
}

}
