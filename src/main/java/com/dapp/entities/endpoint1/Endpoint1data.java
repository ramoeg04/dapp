package com.dapp.entities.endpoint1;

public class Endpoint1data {
	public Endpoint1data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint1data(String id, String name, String image, Integer qr, Boolean push_notification) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.qr = qr;
		this.push_notification = push_notification;
	}
	private String id;
	private String name;
	private String image;
	private Integer qr;
	private Boolean push_notification;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getQr() {
		return qr;
	}
	public void setQr(Integer qr) {
		this.qr = qr;
	}
	public Boolean getPush_notification() {
		return push_notification;
	}
	public void setPush_notification(Boolean push_notification) {
		this.push_notification = push_notification;
	}
	@Override
	public String toString() {
		return "Endpoint1data [id=" + id + ", name=" + name + ", image=" + image + ", qr=" + qr + ", push_notification="
				+ push_notification + "]";
	}

}
