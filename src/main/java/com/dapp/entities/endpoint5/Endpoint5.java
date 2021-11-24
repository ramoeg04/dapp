package com.dapp.entities.endpoint5;

public class Endpoint5 {
	public Endpoint5() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint5(int rc, String msg, Endpoint5data data) {
		super();
		this.rc = rc;
		this.msg = msg;
		this.data = data;
	}
	private int rc;
	private String msg;
    private Endpoint5data data;
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
	public Endpoint5data getData() {
		return data;
	}
	public void setData(Endpoint5data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Endpoint5 [rc=" + rc + ", msg=" + msg + ", data=" + data + "]";
	}
}
