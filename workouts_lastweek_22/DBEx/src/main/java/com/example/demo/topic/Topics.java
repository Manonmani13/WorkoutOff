package com.example.demo.topic;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Topics {
	@Id
private String id;
private String name;
private String des;
public String getId() { 
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}
public Topics()
{
	
}
public Topics(String string, String name, String des) {
	super();
	this.id = id;
	this.name = name;
	this.des = des;
}

}
