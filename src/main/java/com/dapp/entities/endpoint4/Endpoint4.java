package com.dapp.entities.endpoint4;

public class Endpoint4 {
	
	public Endpoint4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint4(int rc, String msg, Endpoint4data data) {
		super();
		this.rc = rc;
		this.msg = msg;
		this.data = data;
	}
	private int rc;
	private String msg;
	private Endpoint4data data;
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
	public Endpoint4data getData() {
		return data;
	}
	public void setData(Endpoint4data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Endpoint4 [rc=" + rc + ", msg=" + msg + ", data=" + data + "]";
	}
	

}
