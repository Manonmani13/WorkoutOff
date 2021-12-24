package com.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.Service.TeacherService;
import com.teacher.entity.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
@Autowired
TeacherService teacherService;
@PostMapping()
public Teacher saveTeacher(@RequestBody Teacher teacher)
{
	return teacherService.saveTeacher(teacher);
}

@GetMapping("/{id}")
public Teacher getTeacherById(@PathVariable("id")int id)
{
	return teacherService.getTeacherById(id);
}

}

