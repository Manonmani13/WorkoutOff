package com.example.demo.comm;

import com.example.demo.entity.Employee;

public class ResponseTemplate {
	
private Employee employee;
private Manager manager;

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public Manager getManager() {
	return manager;
}

public void setManager(Manager manager) {
	this.manager = manager;
}

public ResponseTemplate(Employee employee, Manager manager) {
	super();
	this.employee = employee;
	this.manager = manager;
}

public ResponseTemplate() {
	super();
}


}
