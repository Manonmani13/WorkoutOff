package com.workout.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="UserDetails")
public class UserInfo {
	@Id
	@Column(name="userId")
private int userId;
	@Column(name="FirstName")
private String firstName;
	@Column(name="lastName")
private String lastName;
	@Column(name="phoneNo")
private int phone;
	@Column(name="Organization")
private String organization;
	@Column(name="CreatedBy")
private int createdBy;
	@Column(name="UpdatedAt")
	private final LocalTime localTimeupdate=LocalTime.now();
	@Column(name="UpdatedBy")
private int updatedBy;
	@Column(name="CreatedAt")
private final LocalTime localTime=LocalTime.now();
	
	@Column(name="UserKey")
private int userKey;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getOrganization() {
	return organization;
}
public void setOrganization(String organization) {
	this.organization = organization;
}
public int getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(int createdBy) {
	this.createdBy = createdBy;
}
public int getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(int updatedBy) {
	this.updatedBy = updatedBy;
}
public int getUserKey() {
	return userKey;
}
public void setUserKey(int userKey) {
	this.userKey = userKey;

}
public UserInfo(int userId, String firstName, String lastName, int phone, String organization, int createdBy,int updatedBy,  int userKey) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
	this.organization = organization;
	this.createdBy = createdBy;
	this.updatedBy = updatedBy;
	this.userKey = userKey;
}
public UserInfo() {

}

}
