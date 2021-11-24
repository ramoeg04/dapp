package com.dapp.entities.endpoint4;

public class Endpoint4client {

	public Endpoint4client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endpoint4client(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Endpoint4client [name=" + name + "]";
	}

}
