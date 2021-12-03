package com.workout.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workout.model.Emp;
import com.workout.service.EmpService;

@Controller
@RequestMapping("controller/emp")
public class EmpController {
@Autowired
private  EmpService empservice;
 @PostMapping
 public String saveemp(@RequestBody Emp emp)
 {
	 Optional <Emp>_emp=empservice.create(emp);
     if(_emp.isPresent()){
         return "The employee data has been saved successfully!";
     }else{
         return "Employee already exist in records";
     }
	 
 }

 @GetMapping("/{id}")
 public ResponseEntity<Emp> getEmployeeById(@PathVariable("id") int id) {
   Optional<Emp> employee = empservice.Readone(id);  
   if (employee.isPresent()) {
     return new ResponseEntity<>(employee.get(), HttpStatus.OK);
   } else {
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
 }    

 @GetMapping
 public List<Emp> getALLEmployees() {
   return empservice.Read();
 }

 @PutMapping
 public String updateEmployee(@RequestBody Emp employee) {
     Optional<Emp> _employee = empservice.update(employee);
     if(_employee.isEmpty()){
         return "The employee data does not exist in records!";
     }else{
         return "The employee data has been updated successfully!";
     }
 }

 @DeleteMapping("/{id}")
 public String deleteEmployeeById(@PathVariable("id") int id) {
   return  empservice.delete(id);   
 }
}
