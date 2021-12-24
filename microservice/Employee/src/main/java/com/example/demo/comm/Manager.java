package com.example.demo.comm;

public class Manager {
	
	private long managerId;
	private String managerName;
	private String managerDepartment;

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerDepartment() {
		return managerDepartment;
	}

	public void setManagerDepartment(String managerDepartment) {
		this.managerDepartment = managerDepartment;
	}

	public Manager(long managerId, String managerName, String managerDepartment) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerDepartment = managerDepartment;
	}

	public Manager() {
		super();
	}

}
