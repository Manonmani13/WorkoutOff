package com.workout.repository;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workout.model.Emp;
@Repository
public interface EmpRepository extends JpaRepository<Emp,Integer> {

}
