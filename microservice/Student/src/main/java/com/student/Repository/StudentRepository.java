package com.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

	StudentEntity getByStudentId(int studId);



}
