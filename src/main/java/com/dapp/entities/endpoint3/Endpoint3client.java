package com.dapp.entities.endpoint3;

public class Endpoint3client {

	public Endpoint3client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endpoint3client(String name) {
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
