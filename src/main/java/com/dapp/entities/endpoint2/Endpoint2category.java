package com.dapp.entities.endpoint2;

public class Endpoint2category {
	public Endpoint2category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint2category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Endpoint2category [id=" + id + ", name=" + name + "]";
	}
}
