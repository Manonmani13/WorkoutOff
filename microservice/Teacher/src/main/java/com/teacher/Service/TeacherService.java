package com.teacher.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.Repository.TeacherRepository;
import com.teacher.entity.Teacher;

@Service
public class TeacherService {
@Autowired
private TeacherRepository teacherRepository;

public Teacher saveTeacher(Teacher teacher) {
	// TODO Auto-generated method stub
return teacherRepository.save(teacher);
	}



public Teacher getTeacherById(int id) {
	return teacherRepository.findById(id).get();

}

}
