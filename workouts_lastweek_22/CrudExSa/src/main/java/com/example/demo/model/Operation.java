package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="Details")
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="name")
private String name;
	@Column (name="Dob")
private String DOB;
public Operation()
{
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
public Operation(String name, String dOB) {
	super();
	this.name = name;
	DOB = dOB;
}
public String toString()
{
	return "Details [Name"+name+"DOB"+DOB+"]";
}
}
