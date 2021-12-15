package com.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int departmentid;
private String departmentname;
public Department() {
}
@Override
public String toString() {
	return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + ", departmentcode="
			+ departmentcode + "]";
}
public Department(int departmentid, String departmentname, int departmentcode) {
	super();
	this.departmentid = departmentid;
	this.departmentname = departmentname;
	this.departmentcode = departmentcode;
}
public int getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(int departmentid) {
	this.departmentid = departmentid;
}
public String getDepartmentname() {
	return departmentname;
}
public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}
public int getDepartmentcode() {
	return departmentcode;
}
public void setDepartmentcode(int departmentcode) {
	this.departmentcode = departmentcode;
}
private int departmentcode;

}
