package com.student.comm;

import com.student.entity.StudentEntity;

public class ResponseTemplateComm {
	
	private StudentEntity student;
	private Teacher teacher;
	
	public StudentEntity getStudent() {
		return student;
	}
	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public ResponseTemplateComm(StudentEntity student, Teacher teacher) {
		super();
		this.student = student;
		this.teacher = teacher;
	}
	
	public ResponseTemplateComm() {
		super();
	}
	
	
		
}
