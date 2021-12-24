package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Service.StudentService;
import com.student.comm.ResponseTemplateComm;
import com.student.entity.StudentEntity;

@RestController
@RequestMapping("/student")
public class StudentControleler {
@Autowired
private StudentService studentService;
@PostMapping()
public StudentEntity saveStudent(@RequestBody StudentEntity student)
{
	return studentService.saveStudent(student);
}
@GetMapping("/{id}")
public ResponseTemplateComm  getStudentWithTeacherId(@PathVariable("id")  int stuId)
{
	return studentService.getStudentwithTeacherId(stuId);
}
}