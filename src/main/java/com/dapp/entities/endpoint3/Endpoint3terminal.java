package com.dapp.entities.endpoint3;

public class Endpoint3terminal {
	public Endpoint3terminal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint3terminal(String employee, String name) {
		super();
		this.employee = employee;
		this.name = name;
	}
	private String employee; 
	private String name;
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Endpoint3terminal [employee=" + employee + ", name=" + name + "]";
	} 

}
