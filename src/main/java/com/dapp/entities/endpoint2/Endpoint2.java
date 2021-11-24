package com.dapp.entities.endpoint2;

import java.util.List;

public class Endpoint2 {

	public Endpoint2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint2(int rc, String msg, Endpoint2data data) {
		super();
		this.rc = rc;
		this.msg = msg;
		this.data = data;
	}
	private int rc;
	private String msg;
	private Endpoint2data data;
	public int getRc() {
		return rc;
	}
	public void setRc(int rc) {
		this.rc = rc;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Endpoint2data getData() {
		return data;
	}
	public void setData(Endpoint2data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Endpoint2 [rc=" + rc + ", msg=" + msg + ", data=" + data + "]";
	}
	

}
