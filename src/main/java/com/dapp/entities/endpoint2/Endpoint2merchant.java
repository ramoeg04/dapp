package com.dapp.entities.endpoint2;

import java.util.List;

public class Endpoint2merchant {
	
	public Endpoint2merchant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint2merchant(String id, String name, String address, String image, Endpoint2category category) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.image = image;
		this.category = category;
	}
	private String id;
	private String name;
	private String address;
	private String image;
	private Endpoint2category category;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Endpoint2category getCategory() {
		return category;
	}
	public void setCategory(Endpoint2category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Endpoint2merchant [id=" + id + ", name=" + name + ", address=" + address + ", image=" + image
				+ ", category=" + category + "]";
	}
	
}
