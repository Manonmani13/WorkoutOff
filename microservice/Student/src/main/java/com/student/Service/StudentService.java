package com.student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.Repository.StudentRepository;
import com.student.comm.ResponseTemplateComm;
import com.student.comm.Teacher;
import com.student.entity.StudentEntity;

@Service
public class StudentService {
	
@Autowired
StudentRepository studentRepository;

@Autowired
RestTemplate restTemplate;

public StudentEntity saveStudent(StudentEntity student) {
	
	return studentRepository.save(student);
}

//public StudentEntity getStudentById(int stuId) {
//	// TODO Auto-generated method stub
//	return studentRepository.findById(stuId).get();
//}

public ResponseTemplateComm getStudentwithTeacherId(int studId) {
	
	ResponseTemplateComm comm = new ResponseTemplateComm();
	
	StudentEntity student = studentRepository.getByStudentId(studId);
	Teacher teacher = restTemplate.getForObject("http://localhost:9090/teacher/"+student.getTeacherId(), Teacher.class);
	comm.setStudent(student);
	comm.setTeacher(teacher);
	return comm;
}


}
