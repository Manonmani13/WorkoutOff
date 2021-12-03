package com.workout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.model.Emp;
import com.workout.repository.EmpRepository;

@Service
public class EmpService {
@Autowired
private EmpRepository emprepo;
public  Optional <Emp> create(Emp emp)
{
	if(emprepo.existsById(emp.getId()))
	{
		return  Optional.empty();
	}
	else
	{
		return Optional.of(emprepo.save(emp));
	}
}
public List<Emp> Read()
{
return emprepo.findAll();
}
public  Optional <Emp>Readone(int id)
{
	return emprepo.findById(id);
}
public  Optional<Emp> update (Emp emp)
{
	if(emprepo.existsById(emp.getId()))
	{
		return Optional.of(emprepo.save(emp));
	}
	else
	{
		return Optional.empty();
	}
}
public String  delete(int empid)
{
	if(emprepo.existsById(empid))
	{
	 	emprepo.deleteById(empid);
	 	return empid+"Deleted Successfully";
	}
	else
	{
		return "The Employee  data does  not exist  in records";
	}
}
}
