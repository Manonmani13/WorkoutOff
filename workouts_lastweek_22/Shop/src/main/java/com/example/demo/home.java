package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class home {
	public home()
	{
		System.out.println("Welcome to home");
	}
private int doorno;
private String owner;
@Autowired
private InternetConnection modem;
public int getDoorno() {
	return doorno;
}
public void setDoorno(int doorno) {
	this.doorno = doorno;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public void connect()
{
	modem.switchon();
	System.out.println("Connecting to internet");
}
}
