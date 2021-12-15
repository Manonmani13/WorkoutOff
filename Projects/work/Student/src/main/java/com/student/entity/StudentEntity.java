package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="StudentDetails")
public class StudentEntity {
@Id
private int studentId;
private String name;
private int phone;
private int teacherId;
public StudentEntity(int studentId, String name, int phone, int teacherId) {
	super();
	this.studentId = studentId;
	this.name = name;
	this.phone = phone;
	this.teacherId = teacherId;
}
public StudentEntity() {
	super();
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public int getTeacherId() {
	return teacherId;
}
public void setTeacherId(int teacherId) {
	this.teacherId = teacherId;
}


}
